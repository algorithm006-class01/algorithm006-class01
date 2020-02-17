"""
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
        pass

    @classmethod
    def recursive(cls, n: int) -> int:
        """
            递归解决：
                f(n) = f(n-1) + f(n)
                终止条件 n小于3时，返回对应n。
            时间复杂度O(2^n)，空间复杂度O(n)
        """
        if n < 3:
            return n
        return cls.recursive(n - 1) + cls.recursive(n - 2)

    @classmethod
    def recursive_use_hash(cls, n: int) -> int:
        """
            和递归方法一样，只是用一个hash表记录一下每个数的值，防止重复计算。
            时间复杂度O(n)，空间复杂度是O(n)
        """

        def recursive(_n: int, mapping: dict = None) -> int:
            mapping = mapping or {}
            if _n < 3:
                return 2
            if _n in mapping:
                return mapping[_n]
            else:
                result = recursive(_n - 1) + recursive(_n - 2)
                mapping[_n] = result
                return result

        return recursive(n)

    @classmethod
    def loop_compute(cls, n: int) -> int:
        """
            自低向上计算
            时间复杂度O(n)，空间复杂度O(1)
        """
        if n < 3:
            return n

        a, b = 1, 2
        for i in range(3, n + 1):
            a, b = b, a + b
        return b
