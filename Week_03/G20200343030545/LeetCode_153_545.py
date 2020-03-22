"""
    假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    请找出其中最小的元素。
    你可以假设数组中不存在重复元素。

    示例 1:
        输入: [3,4,5,1,2]
        输出: 1

    示例 2:
        输入: [4,5,6,7,0,1,2]
        输出: 0

    https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
"""
from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        return self.use_mid(nums)

    @classmethod
    def use_mid(cls, nums: List[int]) -> int:
        """
            二分查找
        """
        if nums:
            left = 0
            right = len(nums) - 1
            # 特殊情况判断
            if nums[left] <= nums[right]:
                return nums[left]

            while right >= left:
                mid = (left + right) // 2
                mid_val = nums[mid]

                if mid_val > nums[mid + 1]:
                    return nums[mid + 1]

                if mid_val < nums[mid - 1]:
                    return mid_val

                if mid_val > nums[0]:
                    left = mid + 1
                else:
                    right = mid - 1

    @classmethod
    def directly(cls, nums: List[int]) -> int:
        """
            遍历一边原始数组
            时间复杂度：O(n)
            空间复杂度：O(1)
        """
        res = float("inf")
        for num in nums:
            res = min(res, num)
        return res
