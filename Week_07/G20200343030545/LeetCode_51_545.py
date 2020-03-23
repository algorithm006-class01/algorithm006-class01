"""
    n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
    每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

    示例:
        输入: 4
        输出: [
         [".Q..",  // 解法 1
          "...Q",
          "Q...",
          "..Q."],

         ["..Q.",  // 解法 2
          "Q...",
          "...Q",
          ".Q.."]
        ]
        解释: 4 皇后问题存在两个不同的解法。
"""
from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        return self.use_dfs(n)

    @classmethod
    def use_dfs(cls, n: int) -> List[List[str]]:
        """
            一行只有一个皇后 且一列也只有一个皇后
            所以可以按列来循环，没有必须要循环棋盘的所有方格。
            然后 row+col  == pie   row + col = na

        """
        res = []

        def helper(cols, xy_diff, xy_sum):
            if len(cols) == n:
                res.append(cols)

            row = len(cols)
            for col in range(n):
                if col not in cols and row - col not in xy_diff and row + col not in xy_sum:
                    helper(cols + [col], xy_diff + [row - col], xy_sum + [row + col])

        helper([], [], [])
        return res
