# -*- coding:utf-8 -*-
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        #需要从一个整数数组里面任意找出两个整数他们的和与指定的值相同
        # 1.迭代找出每个两位数,顺序取一个元素为主元素，然后依次再去一个剩下的元素，
        # 两个一起匹配结果，如果每个子元素都匹配完依然没有结果就使用下一个主元素，
        # 依次使用完所有元素，如果没有就不能满足
        # 2. 然后匹配指定目标值
        i = 0
        j = 0
        length = len(nums)
        while True:
            if j >= length:
                return False
            
            master = nums[j]
            for i in range(j+1, length):
                iterm = nums[i]
                if master + iterm == target:
                    return [j, i]
            j = j + 1

if __name__ == "__main__":
    obj = Solution()
    print(obj.twoSum([11, 15, 2, 7], 9))
                            
            
                