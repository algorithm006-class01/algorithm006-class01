"""
    爬楼梯问题
    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

    注意：给定 n 是一个正整数。

    示例 1：
        输入： 2
        输出： 2
        解释： 有两种方法可以爬到楼顶。
        1.  1 阶 + 1 阶
        2.  2 阶

    示例 2：
        输入： 3
        输出： 3
        解释： 有三种方法可以爬到楼顶。
        1.  1 阶 + 1 阶 + 1 阶
        2.  1 阶 + 2 阶
        3.  2 阶 + 1 阶
"""


class Solution:
    def climbStairs(self, n: int) -> int:
        return self.dp_1(n)

    @classmethod
    def dp_1(cls, n: int) -> int:
        """
            定义一个dp数组 dp[i] 表示第i阶有多少种不同的方法可以爬楼梯
            dp[i] = dp[i-1] + dp[i-2]
        """
        if n < 3:
            return n
        dp = [0] * (n + 1)

        dp[1] = 1
        dp[2] = 2
        for i in range(3, n + 1):
            dp[i] = dp[i - 1] + dp[i - 2]
        return dp[n]

    @classmethod
    def dp_2(cls, n: int) -> int:
        first, second = 1, 1
        for i in range(1, n):
            first, second = second, second + first
        return second
