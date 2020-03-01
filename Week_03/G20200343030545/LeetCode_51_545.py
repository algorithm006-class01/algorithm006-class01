"""
    n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
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

    https://leetcode-cn.com/problems/n-queens
"""
from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        self.recursive([], [], [], n, res)
        return [["." * col + "Q" + (n - col - 1) * "." for col in row] for row in res]

    @classmethod
    def recursive(cls, queues: List[int], xy_diff: List[int], xy_sum: List[int], n: int, res: List[List[int]]):
        # terminator
        row = len(queues)
        if row == n:
            res.append(queues[:])
            return

        for col in range(n):
            if col not in queues and row - col not in xy_diff and row + col not in xy_sum:
                queues.append(col)
                xy_diff.append(row - col)
                xy_sum.append(row + col)
                cls.recursive(queues, xy_diff, xy_sum, n, res)
                queues.pop()
                xy_diff.pop()
                xy_sum.pop()


if __name__ == "__main__":
    print(Solution().solveNQueens(8))
