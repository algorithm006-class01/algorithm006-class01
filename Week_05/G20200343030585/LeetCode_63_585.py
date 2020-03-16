# -*- coding=utf-8 -*-
#
# @lc app=leetcode.cn id=63 lang=python
#
# [63] 不同路径 II
#
# 解题思路
# 1.动态规划
#   1.最优子结构
#   2.重复子问题，不断左右找路径结果，
#   每次等于左边一步的次数+上面一步的次数
#   3.无后效性
# 复杂度分析
# 时间复杂度 ： O(M×N) 。长方形网格的大小是 M×N，而访问每个格点恰好一次。
# 空间复杂度 ： O(1)。我们利用 obstacleGrid 作为 DP 数组，因此不需要额外的空间。

# @lc code=start
class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        if not obstacleGrid:
            return 0
        
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        
        matrix = [[0] * n for _ in range(m)]
        if obstacleGrid[0][0] == 1:
            return 0
        else:
            matrix[0][0] = 1
        
        for i in range(1, n):
            if obstacleGrid[0][i] == 1:
                matrix[0][i] = 0
            else:
                matrix[0][i] = matrix[0][i-1]
        # print(matrix)

        # 第一列
        for j in range(1,m):
            if obstacleGrid[j][0] == 1:
                matrix[j][0] = 0
            else:
                matrix[j][0] = matrix[j-1][0]
        # print(matrix)
        for i in range(1, m):
            for j in range(1, n):
                # print(matrix)
                if obstacleGrid[i][j] == 1:

                    matrix[i][j] = 0
                else:
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-1]
                    
        return matrix[-1][-1]
# @lc code=end

if __name__ == "__main__":
    obj = Solution()
    ret = obj.uniquePathsWithObstacles([[0,0],[1,1],[0,0]])
    print(ret)
