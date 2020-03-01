"""
    假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
    你可以假设数组中不存在重复的元素。
    你的算法时间复杂度必须是 O(log n) 级别。

    示例 1:
        输入: nums = [4,5,6,7,0,1,2], target = 0
        输出: 4

    示例 2:
        输入: nums = [4,5,6,7,0,1,2], target = 3
        输出: -1
"""

from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        return self.mid_query(nums, target)

    @classmethod
    def directly(cls, nums: List[int], target: int) -> int:
        """
            时间复杂度 O(n)  不符合要求
            空间复杂度 O(1)
        """
        for index, num in enumerate(nums):
            if num == target:
                return index
        return -1

    @classmethod
    def mid_query(cls, nums: List[int], target: int) -> int:
        """
            硬套 二分查找模版
            时间复杂度：O(logn)
            空间复杂度：O(1)
        """
        start = 0
        end = len(nums) - 1

        while end >= start:
            mid = (start + end) // 2

            start_val = nums[start]
            mid_val = nums[mid]
            end_val = nums[end]

            if mid_val == target:
                return mid

            if mid_val < end_val:
                # 说明后半部分是单调递增
                if mid_val < target <= end_val:
                    start = mid + 1
                else:
                    end = mid - 1
            else:
                if start_val <= target < mid_val:
                    end = mid - 1
                else:
                    start = mid + 1
        return -1


class SolutionExt:
    """
         寻找一个旋转序数组中的 中间无效的地方, 假设坏点只出现了一次
         比如 [1,2,3,4,5,1,2,5,6,9]
         思路：
            先找出坏点，也就是从哪个位置开始不是单调递增的

    """

    def find_bat_pointer(self, nums: List[int]):
        start = 0
        end = len(nums) - 1
        while end >= start:
            mid = (start + end) // 2
            mid_val = nums[mid]
            end_val = nums[end]

            if mid_val > end_val:
                # 说明前半部分是有序的
                start = mid + 1
            else:
                if mid_val > nums[mid + 1]:
                    start = mid + 1
                else:
                    end = mid - 1
        print(f"start:{start} end:{end}")


if __name__ == '__main__':
    [1, 2, 3, 7, 1, 2, 4]  # start :4 end:3
    SolutionExt().find_bat_pointer([7, 8, 9, 10, 14, 13, 49])
