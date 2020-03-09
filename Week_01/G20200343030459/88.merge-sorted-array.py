#
# @lc app=leetcode id=88 lang=python3
#
# [88] Merge Sorted Array
#
# https://leetcode.com/problems/merge-sorted-array/description/
#
# algorithms
# Easy (38.06%)
# Likes:    1702
# Dislikes: 3612
# Total Accepted:    497.1K
# Total Submissions: 1.3M
# Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
#
# Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
# one sorted array.
# 
# Note:
# 
# 
# The number of elements initialized in nums1 and nums2 are m and n
# respectively.
# You may assume that nums1 has enough space (size that is greater or equal to
# m + n) to hold additional elements from nums2.
# 
# 
# Example:
# 
# 
# Input:
# nums1 = [1,2,3,0,0,0], m = 3
# nums2 = [2,5,6],       n = 3
# 
# Output: [1,2,2,3,5,6]
# 
#

# @lc code=start
# 自己的解法 没有抓住 python 的精髓
# class Solution:
#     def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
#         """
#         Do not return anything, modify nums1 in-place instead.
#         """
#         i, j = m - 1, n - 1
#         index = m + n - 1
#         while i >= 0 and j >= 0:
#             if nums1[i] > nums2[j]:
#                 nums1[i], nums1[index] = nums1[index], nums1[i]
#                 i, index = i - 1, index - 1
#             elif nums1[i] < nums2[j]:
#                 nums1[index] = nums2[j]
#                 j, index = j - 1, index - 1
#             else:
#                 nums1[i], nums1[index] = nums1[index], nums1[i]
#                 i, index = i - 1, index - 1
#                 nums1[index] = nums2[j]
#                 j, index = j - 1, index - 1

#         while j >= 0:
#             nums1[index] = nums2[j]
#             j, index = j - 1, index - 1 


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        while m > 0 and n > 0:
            if nums1[m - 1] >= nums2[n - 1]:
                nums1[m + n - 1] = nums1[m - 1]
                m -= 1
            else:
                nums1[m + n - 1] = nums2[n - 1]
                n -= 1
        
        if n > 0:
            nums1[:n] = nums2[:n]
        
# @lc code=end

