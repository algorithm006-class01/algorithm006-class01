#
# @lc app=leetcode id=120 lang=python3
#
# [120] Triangle
#
# https://leetcode.com/problems/triangle/description/
#
# algorithms
# Medium (42.25%)
# Likes:    1611
# Dislikes: 192
# Total Accepted:    224.7K
# Total Submissions: 529.2K
# Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
#
# Given a triangle, find the minimum path sum from top to bottom. Each step you
# may move to adjacent numbers on the row below.
# 
# For example, given the following triangle
# 
# 
# [
# ⁠    [2],
# ⁠   [3,4],
# ⁠  [6,5,7],
# ⁠ [4,1,8,3]
# ]
# 
# 
# The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
# 
# Note:
# 
# Bonus point if you are able to do this using only O(n) extra space, where n
# is the total number of rows in the triangle.
# 
#

# @lc code=start
# 第一种方法 记忆化搜索
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if not triangle:
            return 0
        memo = {}
        return self.dfs(memo, triangle, (0, 0))
        
    def dfs(self, memo, triangle, position) -> int:
        (x, y) = position
        if x == len(triangle):
            return 0
        if position in memo:
            return memo[position]

        left = self.dfs(memo, triangle, (x + 1, y))
        right = self.dfs(memo, triangle, (x + 1, y + 1))

        minium = min(left, right) + triangle[x][y]
        memo[(x, y)] = minium
        return minium

# 第二种方法 自底向上
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if not triangle:
            return 0
        dp = triangle
        for i in range(len(triangle) - 2, -1, -1):
            for j in range(len(triangle[i])):
                dp[i][j] = min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j]
        
        return dp[0][0]


# 第三种方法 自顶向下（滚动数组优化空间）
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        dp = [[0] * n, [0] * n]

        dp[0][0] = triangle[0][0]

        for i in range(1, n):
            dp[i % 2][0] = dp[(i - 1) % 2][0] + triangle[i][0]
            dp[i % 2][i] = dp[(i - 1) % 2][i - 1] + triangle[i][i]
            for j in range(1, i):
                dp[i % 2][j] = min(dp[(i - 1) % 2][j], dp[(i - 1) % 2][j - 1]) + triangle[i][j]
        
        return min(dp[(n - 1) % 2])


# @lc code=end

