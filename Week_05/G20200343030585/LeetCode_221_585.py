#
# @lc app=leetcode.cn id=221 lang=python
#
# [221] 最大正方形
#
# 解题思路
# 1.动态规划
#   1.subproblem 找正方形，
#       1、找到一个4个格子的正方形后在右下角标注+1
#       2、找个4个相邻正方形后，格子里面就会是2，右下角+1=3
#   2.DP数组 和matrix相同
#   3.DP方程
#       dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1
#   
# 
# @lc code=start
class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        
        if not matrix or len(matrix) == 0:
            return 0

        m, n = len(matrix), len(matrix[0])
        # +1 解决边界情况，就是只有一个元素不会循环问题
        dp = [[0]* (n + 1) for _ in range(m + 1)]
        maxlen = 0
        
        # +1 解决边界情况，就是只有一个元素不会循环问题
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                # 判断角上是否是1，保证可以为正方形
                if matrix[i-1][j-1] == '1':
                    # matrix[i][j] = min(int(matrix[i-1][j]), int(matrix[i-1][j-1]), int(matrix[i][j-1])) + 1
                    dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1
                    maxlen = max(maxlen, dp[i][j])
                
        return maxlen * maxlen
    
# @lc code=end

