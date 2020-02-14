"""
    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

    示例:
        给定 nums = [2, 7, 11, 15], target = 9
        因为 nums[0] + nums[1] = 2 + 7 = 9
        所以返回 [0, 1]
"""
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        return self.use_hash(nums, target)

    @classmethod
    def directly(cls, nums: List[int], target: int) -> List[int]:
        """
            暴力求解法
            两层循环嵌套，外层循环从0到n，内层循环从1到n
            时间复杂度O(n^2)，空间复杂度O(1)
        """
        for i in range(len(nums)):
            for j in range(1, len(nums)):
                if nums[i] + nums[j] == target and i != j:
                    return [i, j]

    @classmethod
    def use_hash(cls, nums: List[int], target: int) -> List[int]:
        """
            使用一个字典关系存储元素和下标的对应关系。
            从头开始遍历数组，每次遍历时，以当前遍历的元素为num1，通过target计算num2。
            判断num2是否在字典中，如果在返回当前遍历的index，以及nums2的index，不在就将当前元素的值和下标存入字典中。
            时间复杂度是O(n)，空间复杂度是O(n)
        """
        hash_map = dict()
        for index, row in enumerate(nums):
            other_row = target - row

            if other_row in hash_map:
                return [hash_map[other_row], index]
            hash_map[row] = index


if __name__ == '__main__':
    pass
