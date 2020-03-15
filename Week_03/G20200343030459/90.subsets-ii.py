#
# @lc app=leetcode id=90 lang=python3
#
# [90] Subsets II
#
# https://leetcode.com/problems/subsets-ii/description/
#
# algorithms
# Medium (45.20%)
# Likes:    1356
# Dislikes: 58
# Total Accepted:    251.5K
# Total Submissions: 554.7K
# Testcase Example:  '[1,2,2]'
#
# Given a collection of integers that might contain duplicates, nums, return
# all possible subsets (the power set).
# 
# Note: The solution set must not contain duplicate subsets.
# 
# Example:
# 
# 
# Input: [1,2,2]
# Output:
# [
# ⁠ [2],
# ⁠ [1],
# ⁠ [1,2,2],
# ⁠ [2,2],
# ⁠ [1,2],
# ⁠ []
# ]
# 
# 
#

# @lc code=start
class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums = sorted(nums)
        self.dfs(nums, 0, [], result)
        return result
    def dfs(self, nums: List[int], startIndex: int, subset: List[int], result: List[List[int]]):
        result.append(subset[:])

        for i in range(startIndex, len(nums)):
            if i != startIndex and nums[i] == nums[i - 1]:
                continue
            subset.append(nums[i])
            self.dfs(nums, i + 1, subset, result)
            subset.pop()

# @lc code=end

