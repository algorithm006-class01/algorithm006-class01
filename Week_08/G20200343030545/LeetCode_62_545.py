"""
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
    问总共有多少条不同的路径？
"""
from functools import lru_cache


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return self.recursive(m, n)

    @classmethod
    def recursive(cls, m: int, n: int) -> int:
        @lru_cache(None)
        def helper(i, j):
            if i < 0 or j < 0:
                return 0
            if i == 1 or j == 1:
                return 1
            return helper(i - 1, j) + helper(i, j - 1)

        return helper(m, n)

    @classmethod
    def dp_1(cls, m: int, n: int) -> int:
        """
            状态转移方程:
                dp[i][j] = dp[i+1][j] + dp[i][j+1]
            时间复杂度：O(m*n)
            空间复杂度：O(m*n)
        """
        dp = [[0] * n] * m
        # 初始化dp数组
        for i in range(m):
            dp[i][0] = 1

        for j in range(n):
            dp[0][j] = 1

        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        return dp[-1][-1]

    @classmethod
    def dp_2(cls, m: int, n: int) -> int:
        """
            dp[i][j] = dp[i-1][j] + dp[i][j-1]
            可以只开一个一维数组 用来保存前一行数据
            时间复杂度：O(m*n)
            空间复杂度：O(m)
            假设 m是行 n是列
        """
        dp = [1] * n
        for i in range(1, m):
            for j in range(1, n):
                dp[j] = dp[j] + dp[j - 1]
        return dp[-1]


if __name__ == '__main__':
    print(Solution.dp_2(4, 5))
