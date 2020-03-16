#
# @lc app=leetcode.cn id=221 lang=python3
#
# [221] 最大正方形
#

# @lc code=start
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        # if not matrix:
        #     return 0
        # m = len(matrix)
        # n = len(matrix[0])
        # dp = [[0] * (n) for _ in range(m)]

        # for i in range(m):
        #     for j in range(n):
        #         if matrix[i][j] == "1":
        #             dp[i][j] = 1
                
        #             if i - 1 == -1 or j - 1 == -1:
        #                 continue

        #             count = 0
        #             for k in range(1, dp[i-1][j-1] + 1):
        #                 if matrix[i-k][j] == "1" and matrix[i][j-k] == "1":
        #                     count += 1
        #                 else: 
        #                     break
        #             dp[i][j] += count

        # return (max(map(max, dp)))**2

        res = 0
        if matrix:
            m = len(matrix)
            n = len(matrix[0])
    
            dp = [[0 for j in range(n + 1)] for i in range(m + 1)]
    
            for i in range(m):
                for j in range(n):
                    if matrix[i][j] == '1':
                        dp[i + 1][j + 1] = min(dp[i][j], dp[i][j + 1], dp[i + 1][j]) + 1
                        res = max(res, dp[i + 1][j + 1])

        return res * res


# @lc code=end

