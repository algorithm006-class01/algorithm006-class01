"""
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
    现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
    网格中的障碍物和空位置分别用 1 和 0 来表示。

    说明：m 和 n 的值均不超过 100。

    示例 1:
        输入:
        [
          [0,0,0],
          [0,1,0],
          [0,0,0]
        ]
        输出: 2
        解释:
        3x3 网格的正中间有一个障碍物。
        从左上角到右下角一共有 2 条不同的路径：
        1. 向右 -> 向右 -> 向下 -> 向下
        2. 向下 -> 向下 -> 向右 -> 向右
"""
from typing import List


class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        return self.dp_2(obstacleGrid)

    @classmethod
    def dp_1(cls, obstacleGrid: List[List[int]]) -> int:
        """
            时间复杂度：O(m*n)
            空间复杂度：O(1)
        """
        res = 0
        if obstacleGrid and obstacleGrid[0]:
            m = len(obstacleGrid)
            n = len(obstacleGrid[0])
            if obstacleGrid[0][0] == 1:
                # 表示起始位置就有障碍物，所以直接返回0
                return res

            # 开始 初始化目标数组的第一行和第一列的值
            obstacleGrid[0][0] = 1
            for i in range(1, m):
                obstacleGrid[i][0] = 0 if obstacleGrid[i][0] == 1 else obstacleGrid[i - 1][0]

            for j in range(1, n):
                obstacleGrid[0][j] = 0 if obstacleGrid[0][j] == 1 else obstacleGrid[0][j - 1]

            for i in range(1, m):
                for j in range(1, n):
                    if obstacleGrid[i][j] == 1:
                        # 说明有障碍物
                        obstacleGrid[i][j] = 0
                    else:
                        # 没有障碍物
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]
            res = obstacleGrid[-1][-1]
        return res

    @classmethod
    def dp_2(cls, obstacleGrid: List[List[int]]) -> int:
        """
            时间复杂度：O(n*m)
            空间复杂度：O(n)

        """
        res = 0
        if obstacleGrid and obstacleGrid[0]:
            m = len(obstacleGrid)
            n = len(obstacleGrid[0])
            table = [1] + n * [0]

            for i in range(m):
                for j in range(n):
                    table[j] = 0 if obstacleGrid[i][j] == 1 else table[j - 1] + table[j]
            res = table[-2]
        return res
