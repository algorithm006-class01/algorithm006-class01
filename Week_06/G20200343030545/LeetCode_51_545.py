"""
    n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    上图为 8 皇后问题的一种解法。
    给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
    每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
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
        res = self.dfs(n)
        return [["." * col + "Q" + "." * (n - col - 1) for col in row] for row in res]

    @classmethod
    def dfs(cls, n: int) -> List[List[int]]:
        def helper(queue: List[int], xy_diff: List[int], xy_sum: List[int], check_n: int, tmp_res: List[List[int]]):
            #  terminator
            if len(queue) == check_n:
                tmp_res.append(queue[:])
                return

            # process
            row = len(queue)
            for col in range(n):
                if col not in queue and row - col not in xy_diff and row + col not in xy_sum:
                    queue.append(col)
                    xy_diff.append(row - col)
                    xy_sum.append(row + col)

                    # drill down
                    helper(queue, xy_diff, xy_sum, check_n, tmp_res)

                    # reverse state
                    queue.pop(-1)
                    xy_diff.pop(-1)
                    xy_sum.pop(-1)

        res = []
        helper([], [], [], n, res)

        return res


if __name__ == '__main__':
    print(Solution().solveNQueens(4))
