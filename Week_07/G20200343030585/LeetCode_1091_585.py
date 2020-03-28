# -*- coding:utf-8 -*-
# @lc app=leetcode.cn id=1091 lang=python
#
# [1091] 二进制矩阵中的最短路径
#
# 解题思路
# 1.dp
# 2.bfs
#   1.从头部找起，找8个方向的结点，如果遇到1就剪枝
#   如果遇到n-1的位置就到终点了
#   2.每轮循环要记录层级step
# 3.A*
#   1.从头部开始循环，从8个方向找到所有下一级结点
#   2.使用priorityQueue 记录结点

# @lc code=start
# A* search
import heapq

class Solution(object):
    def shortestPathBinaryMatrix(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if not grid or grid[0][0] == 1 or grid[-1][-1] == 1:
            return -1
        elif len(grid) <= 2:
            return len(grid)
            
        # 估价函数
        def get_heuristic(i, j):
            return abs(m-1 - i)+abs(n-1 - j)
        
        m, n = len(grid), len(grid[0])
        visited = set()
        h = []
        heapq.heappush(h,(0, (0, 0, 1)))

        while h:
            _, (i, j, step) = heapq.heappop(h)
            if (i, j) in visited:
                continue
            visited.add((i,j))
 
            for x, y in [(1, 0), (-1, 0), (0, 1), (0, -1), (1,1), (1, -1), (-1, 1), (-1, -1)]:
                a, b = x + i, y+j
                if a == m - 1 and b == n - 1:
                    return step + 1
                if 0 <= a < m and 0 <= b < n and grid[a][b] == 0:
                   heapq.heappush(h, (step + get_heuristic(a, b), (a, b, step+1)))

        return -1
        
#BFS
# class Solution(object):
#     def shortestPathBinaryMatrix(self, grid):
#         """
#         :type grid: List[List[int]]
#         :rtype: int
#         """
#         # 
#         q, n = [(0, 0, 2)], len(grid)
#         # 两端是阻塞的情况
#         if grid[0][0] or grid[-1][-1]:
#             return -1
#         # 由于是8连通的所以直接可以抵达
#         elif n <= 2:
#             return n
#         # BFS starts
#         for i, j, d in q:
#             # 8个方向查找
#             for x, y in [(i - 1, j - 1), (i - 1, j), (i - 1, j + 1), (i, j - 1),\
#                          (i, j + 1), (i + 1, j - 1),(i + 1, j), (i + 1, j + 1)]:
#                 # x,y在0-n之间，因为x,y就是初始值进行一次变化之后的结果，这里直接判断就可以
#                 # 再判断grid是否为0，1是不能走的，把这样情况的所有子集加到一起，进行下一次循环
#                 if 0 <= x < n and 0 <= y < n and not grid[x][y]:
#                     if x == n - 1 and y == n - 1:
#                         return d
#                     # x,y坐标，然后d是步数
#                     q += [(x, y, d + 1)]
#                     #所有走过的情况标一，涂色
#                     grid[x][y] = 1
#         return -1
        
# @lc code=end
if __name__ == "__main__":
    obj = Solution()
    ret = obj.shortestPathBinaryMatrix(
        [
            [0,0,0,1,0,0,1,0,0,0,0,1,0,0,1,0],
            [0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0],
            [1,0,0,1,1,0,1,0,1,0,0,1,1,0,1,0],
            [0,1,1,1,0,0,0,0,0,1,1,1,0,0,0,0],
            [0,0,0,0,0,1,1,1,0,0,0,0,0,1,1,1],
            [1,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0],
            [1,1,0,0,0,1,0,0,1,1,0,0,0,1,0,0],
            [0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0],
            [0,0,0,1,0,0,1,0,0,0,0,1,0,0,1,0],
            [0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0],
            [1,0,0,1,1,0,1,0,1,0,0,1,1,0,1,0],
            [0,1,1,1,0,0,0,0,0,1,1,1,0,0,0,0],
            [0,0,0,0,0,1,1,1,0,0,0,0,0,1,1,1],
            [1,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0],
            [1,1,0,0,0,1,0,0,1,1,0,0,0,1,0,0],
            [0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0]
        ]
    )
    print(ret)

