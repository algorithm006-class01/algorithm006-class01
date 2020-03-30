#
# @lc app=leetcode.cn id=892 lang=python
#
# [892] 三维形体的表面积
# N*N 看错了题目
# 解题思路
# 1 累加
#   1.一个立方体的表面积= 上下两面+4个面的面积
#   比如：2个立方体一起 1*2 + 4*2 = 10 = num * 1 + num *4
#   2.每两个立方体相邻的情况要减去相邻的最大面积
#   比如：1和3相邻的时候1的面积= 4 + 2 - min(1, 3) = 自己的面积 -  相邻面积的最小值
#   
# @lc code=start
# [[1,3,2], [2,4,4]]  34
# [[1,3,2,4], [2,4,4,5]] 34
class Solution(object):
    def surfaceArea(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if not grid:
            return 0
        
        total = 0
        n = len(grid)
        for i in range(n):
            for j in range(n):
                num = grid[i][j]
                if num > 0: total += num * 4 + 2
                # for x,y in [(1,0),(-1,0),(0,1),(0,-1)]:
                    # if 0 <= i + x < n and 0 <= j+y < n:
                        # total -= min(grid[i+x][j+y], num)
                        
                if i: total -= min(grid[i-1][j], num) * 2
                if j: total -= min(grid[i][j-1], num) * 2
            
        return total
        
        
# class Solution(object):
#     def surfaceArea(self, grid):
#         N = len(grid)

#         ans = 0
#         for r in range(N):
#             for c in range(N):
#                 if grid[r][c]:
#                     ans += 2
#                     for nr, nc in ((r-1, c), (r+1, c), (r, c-1), (r,c+1)):
#                         if 0 <= nr < N and 0 <= nc < N:
#                             nval = grid[nr][nc]
#                         else:
#                             nval = 0

#                         ans += max(grid[r][c] - nval, 0)

#         return ans

# @lc code=end

