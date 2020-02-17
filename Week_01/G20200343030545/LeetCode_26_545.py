"""
    给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

    示例 1:
        给定数组 nums = [1,1,2],
        函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

    示例 2:
        给定 nums = [0,0,1,1,1,2,2,3,3,4],
        函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

    不需要考虑数组中超出新长度后面的元素。
"""
from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        return self.double_pointer(nums)

    @classmethod
    def double_pointer(cls, nums: List[int]) -> int:
        """
            双指针（快慢指针）方法

            i 代表慢指针 初始从0开始。
            j 代表快指针 初始从1开始。
            从j开始依此遍历列表，快指针和慢指针上的数据做比较。如果相等则慢指针不动，反之慢指针加1，然后将快指针所在位置的值赋给慢指针的所在位置上。

            例如：[1, 1, 2, 2, 3, 3]  i=0, j=1
            loop1  nums[1]==nums[0] i不动
            loop2  nums[2]!=nums[0] 先将i+=1，i变为1。再将j的值赋给i，即nums[1]=nums[2]，列表中的元素变为[1,2,2,2,3,3]
            loop3  nums[3]==nums[1] i不动
            loop4  nums[4]!=nums[1] 先将i+=1，i变为2。再将j的值赋给i，即nums[2]=nums[4]，列表中的元素变为[1,2,2,2,3,3]
            loop5  nums[5]==nums[0] i不动
            循环结束，但是i是从0开始的，所以计算列表长度的时候需要返回i+1。
            整体的时间复杂度是O(n)，空间复杂度是O(1)。
        """
        i = 0
        for index in range(1, len(nums)):
            if nums[index] != nums[i]:
                i += 1
                nums[i] = nums[index]
        return i + 1


if __name__ == '__main__':
    print(Solution.double_pointer([1, 2, 3, 4, 5, 5, 5, 5]))
