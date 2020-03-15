#
# @lc app=leetcode id=64 lang=python3
#
# [64] Minimum Path Sum
#
# https://leetcode.com/problems/minimum-path-sum/description/
#
# algorithms
# Medium (50.83%)
# Likes:    2178
# Dislikes: 49
# Total Accepted:    316.9K
# Total Submissions: 620.2K
# Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
#
# Given a m x n grid filled with non-negative numbers, find a path from top
# left to bottom right which minimizes the sum of all numbers along its path.
# 
# Note: You can only move either down or right at any point in time.
# 
# Example:
# 
# 
# Input:
# [
# [1,3,1],
# ⁠ [1,5,1],
# ⁠ [4,2,1]
# ]
# Output: 7
# Explanation: Because the path 1→3→1→1→1 minimizes the sum.
# 
# 
#

# @lc code=start
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        dp = [[0] * m, [0] * m]
        
        dp[0][0] = grid[0][0]

        for i in range(1, m):
            dp[0][i] = dp[0][i - 1] + grid[0][i]

        for i in range(1, n):
            dp[i % 2][0] = dp[(i - 1) % 2][0] + grid[i][0]
            for j in range(1, m):
                dp[i % 2][j] = min(dp[(i - 1) % 2][j], dp[i % 2][j - 1]) + grid[i][j]

        return dp[(n - 1) % 2][m - 1]


# @lc code=end

