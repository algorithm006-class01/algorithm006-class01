"""
    给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
    说明：不要使用任何内置的库函数，如  sqrt。
    示例 1：
        输入：16
        输出：True

    示例 2：
        输入：14
        输出：False
"""


class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        return self.use_mid_query(num)

    @classmethod
    def use_mid_query(cls, num: int) -> bool:
        if num < 2:
            return True

        left, right = 2, num // 2

        while left <= right:
            mid = (left + right) // 2

            check_num = mid * mid

            if check_num == num:
                return True

            if check_num > num:
                right = mid - 1
            else:
                left = mid + 1
        return False
