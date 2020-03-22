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
        """
            时间复杂度：O(nlogn)
            空间负责度：O(logn)
        """

        def recursive(left_index: int, right_index: int) -> int:
            if left_index == right_index:
                return nums[left_index]

            mid_index = (left_index + right_index) // 2
            left_val = recursive(left_index, mid_index)
            right_val = recursive(mid_index + 1, right_index)

            if left_val == right_val:
                return left_val

            left_count = sum(1 for i in range(left_index, right_index + 1) if nums[i] == left_val)
            right_count = sum(1 for i in range(left_index, right_index + 1) if nums[i] == right_val)

            return left_val if left_count > right_count else right_val

        return recursive(0, len(nums) - 1)

    @classmethod
    def use_boyer_moore(cls, nums: List[int]) -> int:
        """
            时间复杂度：O(n)
            空间复杂度：O(1)

        """
        res = count = 0
        for num in nums:
            if count == 0:
                res = num
            count += (1 if res == num else -1)

        return res


if __name__ == '__main__':
    print(Solution.use_divide([3, 2, 3]))
