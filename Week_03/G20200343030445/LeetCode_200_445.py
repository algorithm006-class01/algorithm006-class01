#
# @lc app=leetcode.cn id=200 lang=python3
#
# [200] 岛屿数量
#

# @lc code=start
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        
        x = len(grid)
        y = len(grid[0])
        count = 0

        def find(a, b):
            q = [(a,b)]
            while q:
                i, j = q.pop(0)
                if i-1 >= 0 and grid[i-1][j] == '1':
                    grid[i-1][j] = '0'
                    q.append((i-1, j))
                if j-1 >= 0 and grid[i][j-1] == '1':
                    grid[i][j-1] = '0'
                    q.append((i, j-1))
                if j+1 < y and grid[i][j+1] == '1':
                    grid[i][j+1] = '0'
                    q.append((i, j+1))
                if i+1 < x and grid[i+1][j] == '1':
                    grid[i+1][j] = '0'
                    q.append((i+1, j))

        for i in range(x):
            for j in range(y):
                if grid[i][j] == '1':
                    grid[i][j] = '0'
                    count += 1
                    find(i, j)
        return count    
            
            
# @lc code=end

