class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        counter = 0
        
        def dfs(row,col):
            if row<0 or row>len(grid)-1 or col<0 or col>len(grid[0])-1:
                return
            if grid[row][col] == '0':
                return
            else:
                grid[row][col] = '0'
                dfs(row-1,col)
                dfs(row+1,col)
                dfs(row,col-1)
                dfs(row,col+1)               
        
        for row, line in enumerate(grid):
            for col, value in enumerate(line):
                if value=='1':
                    counter +=1
                    dfs(row, col)
                    
        return counter


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        counter = 0

        def dfs(row,col):
            r = len(grid)
            c = len(grid[0])
            grid[row][col] = '0'
            if row>0 and grid[row-1][col]=='1':
                dfs(row-1,col)
            if row<r-1 and grid[row+1][col]=='1':
                dfs(row+1,col)
            if col>0 and grid[row][col-1]=='1':
                dfs(row,col-1)
            if col<c-1 and grid[row][col+1]=='1':
                dfs(row,col+1)
             
        
        for row, line in enumerate(grid):
            for col, value in enumerate(line):
                if value=='1':
                    counter +=1
                    dfs(row, col)
                    
        return counter
                

from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        counter = 0
        
        def bfs(row,col):
            q = deque()
            q.append((row,col))
            while q:
                row,col = q.popleft()
                
                if row>0 and grid[row-1][col]=='1':
                    grid[row-1][col] = '0'
                    q.append((row-1,col))
                if row<len(grid)-1 and grid[row+1][col] =='1':
                    grid[row+1][col] = '0'
                    q.append((row+1,col))
                if col>0 and grid[row][col-1]=='1':
                    grid[row][col-1] = '0'
                    q.append((row,col-1))
                if col<len(grid[0])-1 and grid[row][col+1]=='1':
                    grid[row][col+1] = '0'
                    q.append((row,col+1))
        
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == '1':
                    counter += 1
                    grid[row][col] = '0'
                    bfs(row,col)
                    
                    
        return counter