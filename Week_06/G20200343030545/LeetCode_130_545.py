"""
    给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
    找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

    示例:

        X X X X
        X O O X
        X X O X
        X O X X

    运行你的函数后，矩阵变为：
        X X X X
        X X X X
        X X X X
        X O X X

    解释:
        被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
        任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
        如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
"""
from typing import List


class Solution:
    DIRECTION = ((1, 0), (-1, 0), (0, 1), (0, -1))

    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        return self.dfs(board)

    def dfs(self, board: List[List[str]]) -> None:
        row_len = len(board)
        col_len = len(board[0]) if row_len else 0

        def helper(row_index, col_index):
            board[row_index][col_index] = "B"
            for tmp_row_index, tmp_col_index in self.DIRECTION:
                new_row_index = tmp_row_index + row_index
                new_col_index = tmp_col_index + col_index
                if 1 <= new_row_index < row_len and 1 <= new_col_index < col_len and board[new_row_index][
                    new_col_index] == "O":
                    helper(new_row_index, new_col_index)

        # 按行来处理
        for i in range(row_len):
            # 第一列
            if board[i][0] == "O":
                helper(i, 0)

            # 最后一列
            if board[i][col_len - 1] == "O":
                helper(i, col_len - 1)

        # 按列来处理
        for j in range(col_len):
            # 第一行
            if board[0][j] == "O":
                helper(0, j)
            # 最后一行
            if board[row_len - 1][j] == "0":
                helper(row_len - 1, j)

        for i in range(row_len):
            for j in range(col_len):
                if board[i][j] == "O":
                    board[i][j] = "X"
                if board[i][j] == "B":
                    board[i][j] = "O"
