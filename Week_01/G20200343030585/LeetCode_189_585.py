# -*- coding:utf-8 -*-

class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
       解决思路
        1. 将需要移动到头部的元素取出，将其他元素后移，将移动的元素放到前面    
        2. 使用反转来实现    
            1.想整体反转，这样所有数据就倒了
            2.再把0-k部分反转
            3.把k-end部分反转
            4.对于旋转的次数比数组元素大的情况，可以理解为把所有元素旋转1遍到多遍后（也就是不改变元素原来的位置），最后执行一遍k - length的操作
            
        """
        if k > len(nums):
            return False
        nums.reverse()
        nums = self.reverse(nums, 0, k - 1)
        nums = self.reverse(nums, k, len(nums) - 1)
        return nums
    
        
    def reverse(self, nums, start, end):
        while True:
            if start >= end:
                break

            temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            start += 1
            end -= 1
        return nums
    
if __name__ == "__main__":
    obj = Solution()
    print(obj.rotate([1,2,3,4,5,6,7,8,9,0], 3))