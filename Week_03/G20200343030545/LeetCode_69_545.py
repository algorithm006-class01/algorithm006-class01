"""
    实现 int sqrt(int x) 函数。
    计算并返回 x 的平方根，其中 x 是非负整数。
    由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

    示例 1:
        输入: 4
        输出: 2

    示例 2:
        输入: 8
        输出: 2
        说明: 8 的平方根是 2.82842...,
             由于返回类型是整数，小数部分将被舍去。
    https://leetcode-cn.com/problems/sqrtx
"""


class Solution:
    def mySqrt(self, x: int) -> int:
        return self.use_mid_query(x)

    @classmethod
    def use_mid_query(cls, x: int) -> int:
        if x in (0, 1):
            return x
        left = 1
        right = x // 2

        while right > left:
            mid = left + (right - left) // 2
            check_sum = mid * mid
            if check_sum > x:
                right = mid - 1
            elif check_sum < x:
                left = mid + 1
            else:
                return mid
        return right


if __name__ == '__main__':
    print(Solution.use_mid_query(4))
