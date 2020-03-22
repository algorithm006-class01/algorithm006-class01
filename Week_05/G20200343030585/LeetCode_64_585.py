#
# @lc app=leetcode.cn id=64 lang=python
#
# [64] 最小路径和
#
# 解题思路
# 1.动态规划
#   1. subproblem 
# 每个结果值等于上一个元素和右一元素和当前元素的和最小
# 所以为重复取最小值
#   2.dp数组 记录每个的最小值，补充上一行和右一列
#   3.dp方程 
#  dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1]

# @lc code=start
# 性能略低
# class Solution(object):
#     def minPathSum(self, grid):
#         """
#         :type grid: List[List[int]]
#         :rtype: int
#         """
#         if not grid:
#             return 0
        
#         m, n = len(grid), len(grid[0])
#         dp = [[float("inf")] * (n+1) for _ in range(m+1)]
#         for i in range(1, m+1):
#             for j in range(1, n+1):
#                 dp[i][j] = grid[i-1][j-1]
#                 if i==1 and j==1:
#                     continue
#                 dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1]
                

#         # print(dp)
#         return dp[-1][-1]
        


# class Solution(object):
#     def minPathSum(self, grid):
#         """
#         :type grid: List[List[int]]
#         :rtype: int
#         """
#         if not grid:
#             return 0
        
#         m, n = len(grid), len(grid[0])
#         # dp = [[float("inf")] * (n+1) for _ in range(m+1)]
#         for i in range(0, m):
#             for j in range(0, n):
#                 if i==0 and j==0:
#                     continue
#                 if i == 0:
#                     grid[i][j] = grid[i][j-1] + grid[i][j]
#                 elif j == 0 and i > 0:
#                     grid[i][j] = grid[i-1][j] + grid[i][j]
#                 else:
#                     grid[i][j] = min(grid[i-1][j], grid[i][j-1]) + grid[i][j]
                

#         # print(grid)
#         return grid[-1][-1]
        
        
        
# @lc code=end

