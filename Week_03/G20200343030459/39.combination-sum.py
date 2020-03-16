#
# @lc app=leetcode id=39 lang=python3
#
# [39] Combination Sum
#
# https://leetcode.com/problems/combination-sum/description/
#
# algorithms
# Medium (53.15%)
# Likes:    3082
# Dislikes: 97
# Total Accepted:    472.7K
# Total Submissions: 883.7K
# Testcase Example:  '[2,3,6,7]\n7'
#
# Given a set of candidate numbers (candidates) (without duplicates) and a
# target number (target), find all unique combinations in candidates where the
# candidate numbers sums to target.
# 
# The same repeated number may be chosen from candidates unlimited number of
# times.
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
# Input: candidates = [2,3,6,7], target = 7,
# A solution set is:
# [
# ⁠ [7],
# ⁠ [2,2,3]
# ]
# 
# 
# Example 2:
# 
# 
# Input: candidates = [2,3,5], target = 8,
# A solution set is:
# [
# [2,2,2,2],
# [2,3,3],
# [3,5]
# ]
# 
# 
#

# @lc code=start
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        if not candidates:
            return result
        self.dfs(candidates, 0, target, [], result)
        return result

    def dfs(self, candidates, startIndex, target, combination, result):
        if target < 0:
            return 
        if target == 0:
            result.append(combination[:])
            return
        
        for i in range(startIndex, len(candidates)):
            if i != 0 and candidates[i] == candidates[i - 1]:
                continue
            combination.append(candidates[i])
            self.dfs(candidates, i, target - candidates[i], combination, result)
            combination.pop()


# @lc code=end

