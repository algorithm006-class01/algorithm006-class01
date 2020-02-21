"""
    给定一个可包含重复数字的序列，返回所有不重复的全排列。
    示例:
    输入:
        [1,1,2]
    输出:
        [
          [1,1,2],
          [1,2,1],
          [2,1,1]
        ]
"""
from typing import List


class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        # nums.sort()
        res = []
        # self.recursive(nums, [], res)
        # return res
        res = []
        self.recursive_2(0, nums, res)
        return res

    @classmethod
    def recursive(cls, nums: List[int], tmp: List[int], res: List[List[int]]):
        if not nums:
            res.append(tmp)
            return

        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            cls.recursive(nums[:i] + nums[i + 1:], tmp + [nums[i]], res)

    @classmethod
    def recursive_2(cls, k: int, nums: List[int], res: List[List[int]]):
        if k == len(nums):
            res.append(nums[:])
            return

        for i in range(k, len(nums)):
            if i != k and nums[i] == nums[k]:
                continue
            nums[i], nums[k] = nums[k], nums[i]
            cls.recursive_2(k + 1, nums, res)
            nums[i], nums[k] = nums[k], nums[i]


if __name__ == '__main__':
    print(Solution().permuteUnique([1, 1, 2, 2]))
