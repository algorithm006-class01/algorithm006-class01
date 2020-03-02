"""
    给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
    一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
    你可以假设网格的四个边均被水包围。

    示例 1:
        输入:
            11110
            11010
            11000
            00000
        输出: 1

    示例 2:
        输入:
            11000
            11000
            00100
            00011
        输出: 3
"""

from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        return self.DFS_HAND(grid)

    def DFS_HAND(self, grid: List[List[str]]) -> int:
        """
            解题思路：如果碰到岛屿则用递归的 方式将岛屿附近所有的岛全部变成0
            时间复杂度：O(m*n)
            空间复杂度：O(m*n)

        """

        count = 0
        if len(grid):
            for row_index, row in enumerate(grid):
                for col_index, col in enumerate(row):
                    if grid[row_index][col_index] == "1":
                        self.DFS(grid, row_index, col_index)
                        count += 1
        return count

    @classmethod
    def DFS(cls, grid: List[List[str]], row_index: int, col_index: int):
        # terminator
        if row_index < 0 or col_index < 0 or row_index >= len(grid) or col_index >= len(grid[0]) or grid[row_index][
            col_index] != "1":
            return

        # process
        grid[row_index][col_index] = 0

        # drill down
        cls.DFS(grid, row_index - 1, col_index)
        cls.DFS(grid, row_index + 1, col_index)
        cls.DFS(grid, row_index, col_index - 1)
        cls.DFS(grid, row_index, col_index + 1)

        # reverse state
