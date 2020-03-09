#
# @lc app=leetcode id=852 lang=python3
#
# [852] Peak Index in a Mountain Array
#
# https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
#
# algorithms
# Easy (70.85%)
# Likes:    472
# Dislikes: 974
# Total Accepted:    128.9K
# Total Submissions: 181.9K
# Testcase Example:  '[0,1,0]'
#
# Let's call an array A a mountain if the following properties hold:
# 
# 
# A.length >= 3
# There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] <
# A[i] > A[i+1] > ... > A[A.length - 1]
# 
# 
# Given an array that is definitely a mountain, return any i such that A[0] <
# A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
# 
# Example 1:
# 
# 
# Input: [0,1,0]
# Output: 1
# 
# 
# 
# Example 2:
# 
# 
# Input: [0,2,1,0]
# Output: 1
# 
# 
# Note:
# 
# 
# 3 <= A.length <= 10000
# 0 <= A[i] <= 10^6
# A is a mountain, as defined above.
# 
# 
#

# @lc code=start
class Solution:
    def peakIndexInMountainArray(self, A: List[int]) -> int:
        start, end = 0, len(A) - 1
        while start + 1 < end:
            mid = start + (end - start) // 2
            if A[mid - 1] < A[mid]:
                start = mid
            else:
                end = mid
        if A[start] > A[end]:
            return start
        else:
            return end

# @lc code=end

