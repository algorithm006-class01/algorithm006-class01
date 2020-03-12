"""
    给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    说明：每次只能向下或者向右移动一步。
    示例:
        输入:
        [
          [1,3,1],
          [1,5,1],
          [4,2,1]
        ]
        输出: 7
        解释: 因为路径 1→3→1→1→1 的总和最小。
"""
from functools import lru_cache
from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        return self.dp_1(grid)

    @classmethod
    def dp_1(cls, grid: List[List[int]]) -> int:
        """
            动态规划
                dp[i,j] 表示 第i 行和第j 列的最小路径和
            状态转移方程
                dp[i,j] = grid[i, j] + min( dp[i+1][j], dp[i][j+1] )
            时间复杂度：O(m*n)
            空间复杂度：O(m*n)
        """
        row_len = len(grid)
        col_len = len(grid[0])

        dp = [[0] * col_len for i in range(row_len)]

        dp[0][0] = grid[0][0]
        for i in range(row_len):
            for j in range(col_len):
                if i == 0 and j != 0:
                    dp[i][j] = grid[i][j] + dp[i][j - 1]
                elif i != 0 and j == 0:
                    dp[i][j] = grid[i][j] + dp[i - 1][j]
                elif i != 0 and j != 0:
                    dp[i][j] += grid[i][j] + min(dp[i - 1][j], dp[i][j - 1])
        return dp[row_len - 1][col_len - 1]

    @classmethod
    def recursive_1(cls, grid: List[List[int]]) -> int:
        """
            递归  自顶向下走 这样好理解但是边界条件比较模糊，需要考虑清楚
            左上角走到右下角开始走
                每次有两种选择：
                    1.向下走 grid[row_index+1][col_index]
                    2.向右走 grid[row_index][col_index+1]
                    取这两者中的最小值 加上自己的所在位置的值

                如果row_index或者col_index到到 最后一行 和者最后一列的下标时，返回grid[row_index][col_index]
                如果row_index或者col_index超出了最后一行或最后一列的下标时 返回无穷大
        """
        col_len = len(grid[0])
        row_len = len(grid)

        @lru_cache(None)
        def helper(row_index, col_index):
            if row_index == row_len or col_index == col_len:
                return float("inf")
            elif row_index == row_len - 1 and col_index == col_len - 1:
                return grid[row_index][col_index]
            else:
                return grid[row_index][col_index] + min(
                    helper(row_index + 1, col_index), helper(row_index, col_index + 1)
                )

        return helper(0, 0)

    @classmethod
    def recursive_2(cls, grid: List[List[int]]) -> int:
        """
            递归 自底向上 远离和1一样只不过时从下往上算
        """
        row_len = len(grid)
        col_len = len(grid[0])

        @lru_cache(None)
        def helper(row_index, col_index):
            if row_index == 0 and col_index == 0:
                return grid[row_index][col_index]
            if row_index < row_len - 1 or col_index < col_len - 1:
                return float("inf")
            return grid[row_index][col_index] + min(
                helper(row_index - 1, col_index), helper(row_index, col_index - 1)
            )

        return helper(row_len - 1, col_len - 1)
