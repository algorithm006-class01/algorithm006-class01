
# DFS算法
class Solution(object):
    def numIslands(self, grid:List[List[str]]) -> int:
        if not grid or not grid[0]: return 0
        
        self.row,self.col = len(grid),len(grid[0])
        num = 0

        for i in range(self.row):
            for j in range(self.col):
                if grid[i][j] == '1':
                    self.dfs(grid,i,j)
                    num += 1
        return num
    
    def dfs(self,grid,i,j):
        grid[i][j] = '0'
        for x,y in [(-1,0),(1,0),(0,-1),(0,1)]:
            _i = i + x
            _j = j + y
            if 0 <= _i < self.row and 0 <= _j < self.col and grid[_i][_j] == '1':
                self.dfs(grid,_i,_j)


# BFS算法
class Solution(object):
    def numIslands(self, grid:List[List[str]]) -> int:
        from collections import deque 
        if not grid or not grid[0]: return 0
        self.row,self.col = len(grid),len(grid[0])
        num = 0

        for i in range(self.row):
            for j in range(self.col):
                if grid[i][j] == '1':
                    self.bfs(deque,grid,i,j)
                    num += 1
        return num 
    
    def bfs(self,deque,grid,i,j):
        queue = deque()
        queue.appendleft((i,j))
        grid[i][j] = '0'

        while queue:
            i,j = queue.pop()
            for x,y in [(1,0),(-1,0),(0,1),(0,-1)]:
                _i = i + x 
                _j = j + y 
                if 0 <= _i < self.row and 0 <= _j < self.col and grid[_i][_j] == '1':
                    grid[_i][_j] = '0'
                    queue.appendleft((_i,_j))


# 并查集
class Solution(object):
    def numIslands(self, grid:List[List[str]]) -> int:
        f = {}

        def find(x):
            f.setdefault(x,x)
            if f[x] != x:
                f[x] = find(f[x])
            return f[x]
        
        def union(x,y):
            f[find(x)] = find(y)
        
        if not grid or not grid[0]: return 0
        row = len(grid)
        col = len(grid[0])

        for i in range(row):
            for j in range(col):
                if grid[i][j] == '1':
                    for x,y in [(-1,0),(0,-1)]:
                        _i = i + x
                        _j = j + y
                        if 0 <= _i < row and 0 <= _j < col and grid[_i][_j] == '1':
                            union(_i*col+_j,i*col+j)
        
        res = set()
        for i in range(row):
            for j in range(col):
                if grid[i][j] == '1':
                    res.add(find((i*col+j)))
        
        return len(res)