#
# @lc app=leetcode id=77 lang=python3
#
# [77] Combinations
#
# https://leetcode.com/problems/combinations/description/
#
# algorithms
# Medium (51.97%)
# Likes:    1192
# Dislikes: 60
# Total Accepted:    260.2K
# Total Submissions: 497.9K
# Testcase Example:  '4\n2'
#
# Given two integers n and k, return all possible combinations of k numbers out
# of 1 ... n.
# 
# Example:
# 
# 
# Input: n = 4, k = 2
# Output:
# [
# ⁠ [2,4],
# ⁠ [3,4],
# ⁠ [2,3],
# ⁠ [1,2],
# ⁠ [1,3],
# ⁠ [1,4],
# ]
# 
# 
#

# @lc code=start
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        result = []
        if not n or not k:
            return result
        self.dfs(n, 0, k, [], result)
        return result

    def dfs(self, n, startIndex, k, combination, result):
        if len(combination) == k:
            result.append(combination[:])
            return 
        
        for i in range(startIndex, n):
            combination.append(i + 1)
            self.dfs(n, i + 1, k, combination, result)
            combination.pop()



# @lc code=end

