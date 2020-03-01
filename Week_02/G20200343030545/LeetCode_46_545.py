"""
    给定一个没有重复数字的序列，返回其所有可能的全排列。
    示例:
        输入: [1,2,3]
        输出:
        [
          [1,2,3],
          [1,3,2],
          [2,1,3],
          [2,3,1],
          [3,1,2],
          [3,2,1]
        ]
"""
from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        """
            TODO: 背吧，没理解清楚，多练习几遍
            时间复杂度：
            空间复杂度：O(N!)
        """
        res = []
        if nums:
            self.recursive(nums, res)
        return res

    @classmethod
    def recursive(cls, nums: List[int], res: List[List[int]], start: int = 0):

        # 递归的终止条件
        nums_len = len(nums)
        if nums_len == start:
            res.append(nums[:])

        # 业务逻辑
        for index in range(start, nums_len):
            nums[start], nums[index] = nums[start], nums[index]
            cls.recursive(nums, res, start + 1)
            nums[start], nums[index] = nums[start], nums[index]
