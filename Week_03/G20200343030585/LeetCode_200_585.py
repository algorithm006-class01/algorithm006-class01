#
# @lc app=leetcode.cn id=200 lang=python
#
# [200] 岛屿数量
#
# 解题思路
# 1.深度优先搜索
#   1.线性扫描整个二维网格，如果一个结点包含 1，则以其为根结点启动深度优先搜索。
#   2.在深度优先搜索过程中，每个访问过的结点被标记为 0。计数启动深度优先搜索的根结点的数量，即为岛屿的数量。
#   3.把格子为1的自己和周边等于1的格子都设置为0

#   
# @lc code=start
#
# @lc app=leetcode.cn id=200 lang=python
#
# [200] 岛屿数量
#
# 解题思路
# 1.深度优先搜索
#   1.线性扫描整个二维网格，如果一个结点包含 1，则以其为根结点启动深度优先搜索。
#   2.在深度优先搜索过程中，每个访问过的结点被标记为 0。计数启动深度优先搜索的根结点的数量，即为岛屿的数量。
#   3.把格子为1的自己和周边等于1的格子都设置为0

#   
# @lc code=start
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid:
            return 0

        row = len(grid)
        col = len(grid[0])
        
        res = 0
        
        # 设置当前元素值为0，方便计算
        def DFS(grid, r, c):
            # terminator
            grid[r][c] = '0'

            # 检查上下左右, 注意r-1 or c -1存在等于0的情况
            if r - 1 >= 0 and grid[r - 1][c] == '1': DFS(grid, r - 1, c)
            if r + 1 < row and grid[r + 1][c] == '1': DFS(grid, r + 1, c)
            if c - 1 >= 0 and grid[r][c - 1] == '1': DFS(grid, r, c - 1)
            if c + 1 < col and grid[r][c + 1] == '1': DFS(grid, r, c + 1)
        
        for i in range(row):
            for j in range(col):
                if grid[i][j] == '1':
                    res += 1
                    DFS(grid, i, j)
        return res
        
# @lc code=end


        
# @lc code=end

