"""
    给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

    示例 1:
        输入: 1
        输出: true
        解释: 20 = 1

    示例 2:
        输入: 16
        输出: true
        解释: 24 = 16

    示例 3:
        输入: 218
        输出: false
"""


class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return self.use_and(n)

    @classmethod
    def use_and(cls, n: int) -> bool:
        """
            如果是2的幂次方，则转换成二进制后，所有二进制位上只能有一个1
            可以 用 n & (n-1) 打掉n最低位的一个1 判断这个结果是否等于0。
        """
        return n != 0 and n & (n - 1) == 0

    @classmethod
    def use_recursive(cls, n: int) -> bool:
        return 0 if n <= 0 else 1 + cls.use_recursive(n & (n - 1))
