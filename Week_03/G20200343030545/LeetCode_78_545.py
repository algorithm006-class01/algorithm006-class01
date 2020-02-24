"""
    给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
    说明：解集不能包含重复的子集。

    示例:
        输入: nums = [1,2,3]
        输出:
        [
          [3],
          [1],
          [2],
          [1,2,3],
          [1,3],
          [2,3],
          [1,2],
          []
        ]
"""
from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        if nums:
            res = []
            self.recursive(res, nums, [], 0)

        return res

    @classmethod
    def use_iteration(cls, nums: List[int]) -> List[List[int]]:
        result = [[]]
        for num in nums:
            new_sets = []
            for sub_set in result:
                tmp_set = sub_set + [num]
                new_sets.append(tmp_set)

            result.extend(new_sets)
        return result

    @classmethod
    def recursive(cls, res: List[List[int]], nums: List[int], tmp_nums: List[int], index: int):
        # 1.terminator
        if index == len(nums):
            res.append(tmp_nums[:])
            return

        # 不选这个index
        cls.recursive(res, nums, tmp_nums[:], index + 1)

        # 选这个index
        tmp_nums.append(nums[index])
        cls.recursive(res, nums, tmp_nums[:], index + 1)

        # tmp_nums.pop()


if __name__ == '__main__':
    nums = [1, 2, 3]
    print(Solution.use_iteration(nums))
