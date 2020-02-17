"""
    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

    示例:
        输入: [0,1,0,3,12]
        输出: [1,3,12,0,0]
    说明:
        必须在原数组上操作，不能拷贝额外的数组。
        尽量减少操作次数。
"""
from typing import List


class Solution:

    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        return self.double_pointer_and_swap(nums)

    @classmethod
    def double_pointer_and_swap(cls, nums) -> None:
        """
            双指针并且交换数据：
                初始化一个变量j，从头开始循环nums，如果对应的值不是0，则交换i和j的值，并且j+=1。

            例如: [1, 2, 0 ,0 , 2]
            loop1: [1, 2, 0, 0, 2] j=0  循环完后j=1
            loop2: [1, 2, 0, 0, 2] j=1  循环完后j=2
            loop3: [1, 2, 2, 0, 0] j=2  循环完后j=3
            loop4: [1, 2, 2, 0, 0] j=0  循环完后j=1
            loop5: [1, 2, 2, 0, 0] j=0  循环完后j=1
            时间复杂度 O(n)，空间负载度O(1)
        """
        j = 0
        for i in range(len(nums)):
            if nums[i]:
                nums[i], nums[j] = nums[j], nums[i]
                j += 1
