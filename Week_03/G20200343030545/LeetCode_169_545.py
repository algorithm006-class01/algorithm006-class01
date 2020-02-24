"""
    给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
    你可以假设数组是非空的，并且给定的数组总是存在多数元素。

    示例 1:
        输入: [3,2,3]
        输出: 3

    示例 2:
        输入: [2,2,1,1,1,2,2]
        输出: 2
"""
from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        pass

    @classmethod
    def directly(cls, nums: List[int]) -> int:
        """
            暴力破解法
            时间复杂度：O(n^2)，空间复杂度：O(1)
        """
        check_cnt = len(nums) // 2

        for num in nums:
            cnt = 0
            for tmp_num in nums:
                if num == tmp_num:
                    cnt += 1
            if cnt > check_cnt:
                return num

    @classmethod
    def use_hash(cls, nums: List[int]) -> int:
        """
            使用字典存储
            时间复杂度：O(n)  空间复杂度：O(n)
        """
        mapping = {}
        check_cnt = len(nums) // 2
        for num in nums:
            if num in mapping:
                mapping[num] += 1
            else:
                mapping[num] = 1

        for key, val in mapping.items():
            if val > check_cnt:
                return val
        return -1

    @classmethod
    def use_sort(cls, nums: List[int]) -> int:
        """
            排序
            时间复杂度：O(nlogn) 空间复杂度：O(1)
        """
        nums.sort()
        return nums[len(nums) // 2]

    @classmethod
    def use_divide(cls, nums: List[int]) -> int:

        def recursive(lo, hi):
            if lo == hi:
                return nums[lo]

            mid = (lo + hi) // 2

            left = recursive(lo, mid)
            right = recursive(mid + 1, hi)

            if left == right:
                return left

            left_count = sum(1 for i in range(lo, hi + 1) if nums[i] == left)
            right_count = sum(1 for i in range(lo, hi + 1) if nums[i] == right)

            return left if left_count > right_count else right

        return recursive(0, len(nums) - 1)


if __name__ == '__main__':
    Solution.use_divide([[2, 2, 1, 1, 1, 2, 2]])
