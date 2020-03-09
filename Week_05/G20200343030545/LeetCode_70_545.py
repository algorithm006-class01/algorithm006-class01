"""
    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

    注意：给定 n 是一个正整数。
    示例 1：
        输入： 2
        输出： 2
        解释：
            有两种方法可以爬到楼顶。
            1.  1 阶 + 1 阶
            2.  2 阶

    示例 2：
        输入： 3
        输出： 3
        解释：
            有三种方法可以爬到楼顶。
            1.  1 阶 + 1 阶 + 1 阶
            2.  1 阶 + 2 阶
            3.  2 阶 + 1 阶
"""
from functools import lru_cache


class Solution:
    def climbStairs(self, n: int) -> int:
        assert n > 0
        # return self.recursive(n)
        return self.dp_1(n)

    @classmethod
    @lru_cache(None)
    def recursive(cls, n: int) -> int:
        """
            时间复杂度：O(n)
            空间负载度：O(n)      #因为用了缓存，递归树的节点 只会被计算一次
        """
        if n < 3:
            return n

        return cls.recursive(n - 2) + cls.recursive(n - 1)

    @classmethod
    def dp_1(cls, n: int) -> int:
        a, b = 1, 1
        for i in range(1, n):
            a, b = b, a + b
        return b


class SolutionWith3Cases:
    """
        每次可以上一个台阶或者两个台阶 或者三个台阶
    """

    def climbStairs(self, n: int) -> int:
        assert n > 0
        return self.dp_1(n)

    @classmethod
    @lru_cache(None)
    def recursive(cls, n) -> int:
        if n < 3:
            return n if n != 0 else 1
        return cls.recursive(n - 1) + cls.recursive(n - 2) + cls.recursive(n - 3)

    @classmethod
    def dp_1(cls, n) -> int:
        a, b, c = 1, 1, 2
        for i in range(2, n):
            a, b, c = b, c, a + b + c
        return b if n < 2 else c


class SolutionWith3CasesAndUnique:
    """
        每次可以上一个台阶或者两个台阶 或者三个台阶， 并且每次上的台阶不可以重复，
        比如第一层上1层台阶下一次就不能上一层了，但是下下一次可以上一层

    """

    def climbStairs(self, n: int) -> int:
        assert n > 0
        pass

    @classmethod
    @lru_cache(None)
    def recursive(cls, n) -> int:
        pass
