'''
64. 最小路径和

给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。
'''

class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        if m < 1:
            return 0
        for i in range(0, m):
            for j in range(0, n):
                if i == 0 and j == 0:
                    continue
                if i == 0 and j > 0:
                    grid[i][j] += grid[i][j - 1]
                elif j == 0 and i > 0:
                    grid[i][j] += grid[i - 1][j]
                else:
                    grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])
        return grid[-1][-1]