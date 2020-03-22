#
# @lc app=leetcode id=200 lang=python3
#
# [200] Number of Islands
#
# https://leetcode.com/problems/number-of-islands/description/
#
# algorithms
# Medium (44.73%)
# Likes:    4197
# Dislikes: 155
# Total Accepted:    556.7K
# Total Submissions: 1.2M
# Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
#
# Given a 2d grid map of '1's (land) and '0's (water), count the number of
# islands. An island is surrounded by water and is formed by connecting
# adjacent lands horizontally or vertically. You may assume all four edges of
# the grid are all surrounded by water.
# 
# Example 1:
# 
# 
# Input:
# 11110
# 11010
# 11000
# 00000
# 
# Output: 1
# 
# 
# Example 2:
# 
# 
# Input:
# 11000
# 11000
# 00100
# 00011
# 
# Output: 3
# 
#

# @lc code=start

# 第一种：BFS (AC)
# from collections import deque
# class Solution:
#     def numIslands(self, grid: List[List[str]]) -> int:
#         if not grid or not grid[0]:
#             return 0
#         self.n, self.m = len(grid), len(grid[0])
#         islands = 0
#         for i in range(self.n):
#             for j in range(self.m):
#                 if self.is_island(grid, i, j):
#                     self.bfs_marking(grid, i, j)
#                     islands += 1
        
#         return islands

#     def is_island(self, grid: List[List[str]], x: int, y: int) -> bool:
#         return 0 <= x < self.n and 0 <= y < self.m and grid[x][y] == '1'

#     def bfs_marking(self, grid: List[List[str]], x: int, y: int):
#         dx = [1, 0, -1, 0]
#         dy = [0, 1, 0, -1]
#         queue = deque()
#         queue.append((x, y))
#         grid[x][y] = '0'
#         while queue:
#             head_x, head_y = queue.popleft()
#             for direction in range(4):
#                 adj_x = head_x + dx[direction]
#                 adj_y = head_y + dy[direction]
#                 if not self.is_island(grid, adj_x, adj_y):
#                     continue
#                 queue.append((adj_x, adj_y))
#                 grid[adj_x][adj_y] = '0'

# 第二种： DFS (这次选择使用一个 set)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or not grid[0]:
            return 0
        self.n, self.m = len(grid), len(grid[0])
        islands = 0
        visited = set()
        for i in range(self.n):
            for j in range(self.m):
                if self.is_island(grid, i, j, visited):
                    self.dfs_marking(grid, i, j, visited)
                    islands += 1
        
        return islands

    def is_island(self, grid: List[List[str]], x: int, y: int, visited: set) -> bool:
        return 0 <= x < self.n and 0 <= y < self.m and grid[x][y] == '1' and (x, y) not in visited

    def dfs_marking(self, grid: List[List[str]], x: int, y: int, visited: set):
        dx = [1, 0, -1, 0]
        dy = [0, 1, 0, -1]
        if not self.is_island(grid, x, y, visited):
            return
        visited.add((x, y))
        for direction in range(4):
            adj_x = x + dx[direction]
            adj_y = y + dy[direction]
            self.dfs_marking(grid, adj_x, adj_y, visited)

# @lc code=end

