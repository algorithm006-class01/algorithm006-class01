'''
200. 岛屿数量

给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

示例:
    输入:
    11110
    11010
    11000
    00000

    输出: 1

示例：
    输入:
    11000
    11000
    00100
    00011

    输出: 3

'''
class Solution:
    def numIslands(self, grid) -> int:
        def sink(i, j):
            if 0 <= i < len(grid) and 0 <= j < len(grid[i]) and grid[i][j] == '1':
                grid[i][j] = '0'
                for x,y in zip([i+1, i-1, i, i], [j, j, j+1, j-1]):
                    sink(x,y) 
                return 1
            return 0
        return sum(sink(i, j) for i in range(len(grid)) for j in range(len(grid[i])))