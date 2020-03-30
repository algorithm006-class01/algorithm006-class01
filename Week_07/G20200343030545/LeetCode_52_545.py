"""
    n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    上图为 8 皇后问题的一种解法。

    给定一个整数 n，返回 n 皇后不同的解决方案的数量。

    示例:
        输入: 4
        输出: 2
        解释: 4 皇后问题存在如下两个不同的解法。
        [
         [".Q..",  // 解法 1
          "...Q",
          "Q...",
          "..Q."],

         ["..Q.",  // 解法 2
          "Q...",
          "...Q",
          ".Q.."]
        ]
"""


class Solution:
    def totalNQueens(self, n: int) -> int:
        return self.dfs(n)

    @classmethod
    def dfs(cls, n: int) -> int:
        res = 0

        def helper(rows, xy_diff, xy_sum):
            if len(rows) == n:
                nonlocal res
                res += 1

            row = len(rows)
            for col in range(n):
                if col not in rows and row - col not in xy_diff and row + col not in xy_sum:
                    helper(rows + [col], xy_diff + [row - col], xy_sum + [row + col])

        helper([], [], [])
        return res

    @classmethod
    def use_bit(cls, n: int) -> int:
        res = 0

        def helper(row, cols, pie, na):
            if row == n:
                nonlocal res
                res += 1

            # 得到当前的所有空位
            bits = (~(cols | pie | na)) & ((1 << n) - 1)

            while bits:
                p = bits & -bits

                bits = bits & (bits - 1)
                helper(row + 1, cols | p, (pie | p) << 1, (na | p) >> 1)

        helper(0, 0, 0, 0)
        return res
