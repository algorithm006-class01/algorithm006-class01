"""
    在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

    示例:

    输入:

    1 0 1 0 0
    1 0 1 1 1
    1 1 1 1 1
    1 0 0 1 0

    输出: 4
"""
from typing import List


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        return self.dp_1(matrix)

    @classmethod
    def dp_1(cls, matrix: List[List[str]]) -> int:
        """
            状态转移方程：
                dp[i][j] = min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) + 1
            时间复杂度：O(m*n)
            空间复杂度：O(m*n)
        """

        res = 0
        if matrix:
            m = len(matrix)
            n = len(matrix[0])

            dp = [[0] * (n + 1) for i in range(m + 1)]

            for i in range(1, m + 1):
                for j in range(1, n + 1):
                    if matrix[i - 1][j - 1] == "1":
                        dp[i][j] = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1
                        res = max(res, dp[i][j])
        return res * res
