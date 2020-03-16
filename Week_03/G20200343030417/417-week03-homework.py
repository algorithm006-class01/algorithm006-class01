
# 200 岛屿数量
class Solution(object):
    # 深度优先算法
    def numIslands(self, grid):
        # 记录岛屿的数量
        island_count = 0

        # 深度优先遍历函数
        def dfs(row, col):
            if row not in range(len(grid)) or col not in range(len(grid[0])) or\
                grid[row][col] == "0":
                return
            
            # 当前位置为“1”的话，遍历完改为“0”
            grid[row][col] = "0"

            # 上下左右四个方向遍历
            dfs(row, col-1)
            dfs(row+1, col)
            dfs(row, col+1)
            dfs(row-1, col)
        
    for row in range(len(grid)):
        for col in range(len(grid[0])):
            if grid[row][col] == "1":
                island_count += 1
                dfs(row, col)
    
    return island_count





