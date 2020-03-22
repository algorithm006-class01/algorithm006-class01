"""
    给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
    例如，给定三角形：

    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]
    自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。


    说明：
        如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
"""
from functools import lru_cache
from typing import List


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        return self.recursive(triangle)

    @classmethod
    def dp_1(cls, triangle: List[List[int]]) -> int:
        """
            动态规划  从下往上计算
            状态转移方程：
                problem(i,j)=min(sub_problem(i+1, j), sub_problem(i+1, j)) + triangle[i][j]
            时间复杂度：O(n*n)
            空间复杂度：O(1)
        """
        dp = triangle
        for row in range(len(dp) - 2, -1, -1):
            for col in range(len(dp[row])):
                dp[row][col] += min(dp[row + 1][col], dp[row + 1][col + 1])
        return dp[0][0]

    @classmethod
    def dp_2(cls, triangle: List[List[int]]) -> int:
        """
            从上往下算，
            状态转移方程和上面类似，只不过要注意边界的处理，所以倾向于dp_1的解法。但是我觉得dp_2我更能想到。
            时间复杂度：O(n*n)
            空间复杂度：O(1)
        """
        dp = triangle
        for row in range(1, len(dp)):
            row_len = len(triangle[row])
            for col in range(row_len):
                if col == 0:
                    dp[row][col] += dp[row - 1][col]
                elif col == row_len - 1:
                    dp[row][col] += dp[row - 1][col - 1]
                else:
                    dp[row][col] += min(dp[row - 1][col], dp[row - 1][col - 1])
        return min(dp[-1])

    @classmethod
    def recursive(cls, triangle: List[List[int]]):
        """
            递归
            时间复杂度：O(n^2)
            空间复杂度：O(n^2)
        """

        @lru_cache(None)
        def recursive_(level: int, col_index: int):
            # terminator
            if level == len(triangle) - 1:
                return triangle[level][col_index]
            # drill down
            left = recursive_(level + 1, col_index)
            right = recursive_(level + 1, col_index + 1)
            return min(left, right) + triangle[level][col_index]

        return recursive_(0, 0)


if __name__ == '__main__':
    print(Solution.recursive([[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]))
