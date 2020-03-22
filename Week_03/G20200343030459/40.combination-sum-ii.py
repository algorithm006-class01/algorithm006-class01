#
# @lc app=leetcode id=40 lang=python3
#
# [40] Combination Sum II
#
# https://leetcode.com/problems/combination-sum-ii/description/
#
# algorithms
# Medium (45.51%)
# Likes:    1374
# Dislikes: 55
# Total Accepted:    290.2K
# Total Submissions: 633.9K
# Testcase Example:  '[10,1,2,7,6,1,5]\n8'
#
# Given a collection of candidate numbers (candidates) and a target number
# (target), find all unique combinations in candidates where the candidate
# numbers sums to target.
# 
# Each number in candidates may only be used once in the combination.
# 
# Note:
# 
# 
# All numbers (including target) will be positive integers.
# The solution set must not contain duplicate combinations.
# 
# 
# Example 1:
# 
# 
# Input: candidates = [10,1,2,7,6,1,5], target = 8,
# A solution set is:
# [
# ⁠ [1, 7],
# ⁠ [1, 2, 5],
# ⁠ [2, 6],
# ⁠ [1, 1, 6]
# ]
# 
# 
# Example 2:
# 
# 
# Input: candidates = [2,5,2,1,2], target = 5,
# A solution set is:
# [
# [1,2,2],
# [5]
# ]
# 
# 
#

# @lc code=start
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        if not candidates:
            return result
        candidates = sorted(candidates)
        self.dfs(candidates, 0, target, [], result)
        return result
    
    def dfs(self, candidates, startIndex, target, combination, result):
        if target < 0:
            return
        if target == 0:
            result.append(combination[:])
            return
        
        for i in range(startIndex, len(candidates)):
            if i != startIndex and candidates[i] == candidates[i - 1]:
                continue
            combination.append(candidates[i])
            self.dfs(candidates, i + 1, target - candidates[i], combination, result)
            combination.pop()

# @lc code=end

