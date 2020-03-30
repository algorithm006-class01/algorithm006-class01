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
        res = self.use_dfs(n)
        print(res)
        return [["." * col + "Q" + "." * (n - col - 1) for col in row] for row in res]

    @classmethod
    def use_dfs(cls, n: int):
        res = []

        def helper(queue, xy_sum, xy_diff):
            if len(queue) == n:
                res.append(queue)
                return

            row = len(queue)

            for col in range(n):
                if col not in queue and row - col not in xy_diff and row + col not in xy_sum:
                    helper(queue + [col], xy_sum + [row + col], xy_diff + [row - col])

        helper([], [], [])
        return res


if __name__ == '__main__':
    print(Solution().solveNQueens(4))
