"""
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
    问总共有多少条不同的路径？

    示例 1:
        输入: m = 3, n = 2
        输出: 3
    解释:
        从左上角开始，总共有 3 条路径可以到达右下角。
        1. 向右 -> 向右 -> 向下
        2. 向右 -> 向下 -> 向右
        3. 向下 -> 向右 -> 向右

    示例 2:
        输入: m = 7, n = 3
        输出: 28
 
    提示：
        1 <= m, n <= 100
        题目数据保证答案小于等于 2 * 10 ^ 9
"""


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return self.dp_2(m, n)

    @classmethod
    def dp_1(cls, m: int, n: int) -> int:
        """
            时间复杂度：O(m*n)
            空间负载度：O(m*n)
        """
        res = 0
        if m > 0 and n > 0:
            # 初始化一个table
            table = [[0] * n for i in range(m)]
            # 给定第一行 和第一列初始值
            for i in range(m):
                table[m][0] = 1
            for j in range(n):
                table[0][n] = 1

            for i in range(1, m):
                for j in range(1, n):
                    table[i][j] = table[i - 1][j] + table[i][j - 1]
            res = table[-1][-1]  # 防止数组下标越界
        return res

    @classmethod
    def dp_2(cls, m: int, n: int) -> int:
        """
            时间复杂度：O(m*n)
            空间复杂度：O(n)
            优化了空间复杂度，用一维数组表示每一列的值，计算新值是加上上一列的值就行
        """
        res = 0
        if m > 0 and n > 0:
            table = [1] * n

            for i in range(1, m):
                for j in range(1, n):
                    table[j] = table[j] + table[j - 1]
            res = table[-1]
        return res
