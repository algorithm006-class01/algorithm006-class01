#
# @lc app=leetcode id=88 lang=python
#
# [88] Merge Sorted Array
# 1. use extra list to store 
# and then change the value in nums1 (from small to large), O(n)
# 2. Directly change nums1, from large to small, O(n)
# 3. Direcly use sorted function and renew value in nums1
# @lc code=start

# First
# class Solution(object):
#     def merge(self, nums1, m, nums2, n):
#         """
#         :type nums1: List[int]
#         :type m: int
#         :type nums2: List[int]
#         :type n: int
#         :rtype: None Do not return anything, modify nums1 in-place instead.
#         """
        
#         # extreme case need to be considered first
#         if n == 0:
#             return 
#         if m == 0 and n != 0 :
#             # for i in range (n):
#             #     nums1[i] = nums2[i]
#             nums1[:] = nums2[:]
#             return 
        
#         nums = []
#         p = 0
#         q = 0
#         while p < m and q < n:
#             if nums1[p] < nums2[q]:
#                 nums.append(nums1[p])
#                 p += 1
#             else:
#                 nums.append(nums2[q])
#                 q += 1
                
#         if q < n:
#             nums = nums + nums2[q:]
#         if p < m:
#             nums = nums + nums1[p:]
#         # Note that nums + nums1[p:] may exceed m + n because there
#         # are some 0s in nums 1
#         for i in range(m + n):
#             nums1[i] = nums[i]
    
# Second
# class Solution:
#     def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
#         """
#         Do not return anything, modify nums1 in-place instead.
#         """
#         while m > 0 and n > 0:
#             if nums1[m - 1] > nums2[n - 1]:
#                 nums1[m + n - 1] = nums1[m - 1]
#                 m -= 1
#             else:
#                 nums1[m + n - 1] = nums2[n - 1]
#                 n -= 1
        
#         nums1[:n] = nums2[:n]

# Third
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        nums1[:] = sorted(nums1[:m] + nums2[:n])

# @lc code=end

