"""
    给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
    一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

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
        return self.bfs(grid)

    @classmethod
    def dis_join_set(cls, grid: List[List[str]]) -> int:
        """
            并查集
        """
        pass

    @classmethod
    def bfs(cls, grid: List[List[str]]) -> int:
        """
            广度优先遍历
            一层一层遍历，没从遍历每个元素时，判断其四个方向的元素
            时间复杂度：O(M*N)
            空间负载度：O(min(M,N))
        """
        ret = 0
        if grid:
            m = len(grid)
            n = len(grid[0])

            for i in range(m):
                for j in range(n):
                    if grid[i][j] == "1":
                        ret += 1
                        grid[i][j] = "0"
                        queue = [(i, j)]
                        while queue:
                            cur_i, cur_j = queue.pop()

                            for tmp_i, tmp_j in ((1, 0), (-1, 0), (0, -1), (0, 1)):
                                new_i = tmp_i + cur_i
                                new_j = tmp_j + cur_j

                                if 0 <= new_i < m and 0 <= new_j < n and grid[new_i][new_j] == "1":
                                    grid[new_i][new_j] = "0"
                                    queue.append((new_i, new_j))
        return ret

    @classmethod
    def dfs(cls, grid: List[List[str]]) -> int:
        """
            深度优先遍历
                时间复杂度：O(M*N)  M为行数 N为列数
                空间复杂度：O(M*N)

            思路
                1）从下标0，0开始出发，如果对应的元素内容是1， 则深度优先遍历 判断其相邻的节点，相邻相邻的节点，相邻相邻.....然后回溯。
                2）如果现在判断的下标元素所在的节点是1，则把其置为0
                3）第一步每次开始发起深度优先遍历时，则对应的岛屿的数量+1
        """

        def helper(grid_: List[List[str]], row_index, col_index):
            row_len = len(grid)
            col_len = len(grid[0])
            # terminator
            if 0 <= row_index < row_len and 0 <= col_index < col_len and grid_[row_index][col_index] == "1":
                # process
                grid_[row_index][col_index] = "0"

                for tmp_row_index, tmp_col_index in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                    new_row_index = row_index + tmp_row_index
                    new_col_index = col_index + tmp_col_index
                    # drill down
                    helper(grid, new_row_index, new_col_index)

        ret = 0
        if grid:
            m = len(grid)
            n = len(grid[0])
            for i in range(m):
                for j in range(n):
                    if grid[i][j] == "1":
                        helper(grid, i, j)
                        ret += 1

        return ret
