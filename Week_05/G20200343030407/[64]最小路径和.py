# 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
# 
#  说明：每次只能向下或者向右移动一步。 
# 
#  示例: 
# 
#  输入:
# [
#   [1,3,1],
#   [1,5,1],
#   [4,2,1]
# ]
# 输出: 7
# 解释: 因为路径 1→3→1→1→1 的总和最小。
#  
#  Related Topics 数组 动态规划
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        grid_copy = grid
        m = len(grid)
        n = len(grid[0])
        if m == 1 or n == 1:
            total = 0
            for i in range(m):
                for j in range(n):
                    total = total + grid[i][j]
            return total
        for i in range(m - 2, -1, -1):
            grid_copy[i][n - 1] = grid[i + 1][n - 1] + grid[i][n - 1]
        for j in range(n - 2, -1, -1):
            grid_copy[m - 1][j] = grid[m - 1][j + 1] + grid[m - 1][j]
        for i in range(m - 2, -1, -1):
            row_list = grid[i]
            for j in range(len(row_list) - 2, -1, -1):
                grid_copy[i][j] = grid[i][j] + min(grid_copy[i + 1][j], grid_copy[i][j + 1])
        return grid_copy[0][0]


grid_ = [[1, 7]]
print(Solution().minPathSum(grid_))
# leetcode submit region end(Prohibit modification and deletion)
