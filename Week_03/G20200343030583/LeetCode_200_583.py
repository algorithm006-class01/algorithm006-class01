#
# @lc app=leetcode id=200 lang=python
#
# [200] Number of Islands
# 1. dfs Time:O(row*col)  Space:O(row*col)
# 2. bfs Time:O(row*col) Space:O(min(row,col))
# 3. union find Time:O(row*col) Space:O(row*col)

# @lc code=start
# dfs
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid:
            return 0
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == '1':
                    self.dfs(i,j,grid)
                    count += 1

        return count

    def dfs(self,i,j,grid):
        if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[i]) or grid[i][j] != '1':
            return
        
        grid[i][j] = '0'
        self.dfs(i+1,j,grid)
        self.dfs(i-1,j,grid)
        self.dfs(i,j+1,grid)
        self.dfs(i,j-1,grid)

# bfs
import collections
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid:
            return 0
        count = 0
        queue = collections.deque([])
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == '1':
                    queue.append((i,j))
                    self.bfs(i,j,grid,queue)
                    count += 1
        return count

    def bfs(self,i,j,grid,queue):
        while queue:
            x, y = queue.popleft()
            if x >= 0 and y >= 0 and x < len(grid) and y < len(grid[0]) and grid[x][y] == '1':
                grid[x][y] = '0'
                queue.extend([(x+1,y),(x-1,y),(x,y+1),(x,y-1)])

# bfs by Stefanochmann
def numIslands(self, grid):
    def sink(i, j):
        if 0 <= i < len(grid) and 0 <= j < len(grid[i]) and grid[i][j] == '1':
            grid[i][j] = '0'
            map(sink, (i+1, i-1, i, i), (j, j, j+1, j-1))
            return 1
        return 0
    return sum(sink(i, j) for i in range(len(grid)) for j in range(len(grid[i])))


# Union find 
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid:
            return 0
        
        row,col = len(grid),len(grid[0])
        self.count = sum(grid[i][j]=='1' for i in range(row) for j in range(col))
        parent = [i for i in range(row*col)]

        def find(index):
            while index != parent[index]:
                index = parent[index]
            return index
        
        def union(i,j):
            root_i, root_j = find(i),find(j)
            if root_i == root_j:
                return
            parent[root_j] = root_i
            self.count -= 1
            return 
        
        for i in range(row):
            for j in range(col):
                if grid[i][j] == '1':
                    index = i*col+j
                    if j+1 < col and grid[i][j+1] == '1':
                        union(index,index+1)
                    if i+1 < row and grid[i+1][j] == '1':
                        union(index,index+col)
        
        return self.count

# @lc code=end

