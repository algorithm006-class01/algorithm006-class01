"""
    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
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
from functools import lru_cache


class Solution:
    def climbStairs(self, n: int) -> int:
        return self.recursive(n)

    @classmethod
    @lru_cache(None)
    def recursive(cls, n: int) -> int:
        # terminator
        if n <= 0:
            return 0
        if n < 3:
            return n

        # process

        # drill down
        return cls.recursive(n - 1) + cls.recursive(n - 2)

        # reverse_state
