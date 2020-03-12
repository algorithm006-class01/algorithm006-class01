"""
    给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    说明：每次只能向下或者向右移动一步。
    示例:
        输入:
        [
          [1,3,1],
          [1,5,1],
          [4,2,1]
        ]
        输出: 7
        解释: 因为路径 1→3→1→1→1 的总和最小。
"""
from functools import lru_cache
from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        return self.recursive(grid)

    @classmethod
    def recursive(cls, grid: List[List[int]]) -> int:
        row_len = len(grid)
        col_len = len(grid[0])

        @lru_cache(None)
        def helper(row_index, col_index):
            if row_index == row_len - 1 and col_index == col_len - 1:
                return grid[row_index][col_index]
            elif row_index == row_len or col_index == col_len:
                return float("inf")
            else:
                return grid[row_index][col_index] + min(helper(row_index + 1, col_index),
                                                        helper(row_index, col_index + 1))

        return helper(0, 0)
