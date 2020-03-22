"""
    实现 pow(x, n) ，即计算 x 的 n 次幂函数。

    示例 1:
        输入: 2.00000, 10
        输出: 1024.00000

    示例 2:
        输入: 2.10000, 3
        输出: 9.26100

    示例 3:
        输入: 2.00000, -2
        输出: 0.25000
        解释: 2-2 = 1/22 = 1/4 = 0.25

    说明:
        -100.0 < x < 100.0
        n 是 32 位有符号整数，其数值范围是 [−2**31, 2**31 − 1] 。
"""


class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1 / x
            n = -n
        return self.recursive(x, n)

    @classmethod
    def recursive(cls, x: float, n: int) -> float:
        if n == 0:
            return 1.0

        half = cls.recursive(x, n // 2)

        return half * half if n % 2 == 0 else half * half * x


if __name__ == '__main__':
    print(Solution().myPow(0.00001, 2147483647))
