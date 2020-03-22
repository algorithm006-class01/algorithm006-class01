#
# @lc app=leetcode.cn id=69 lang=python
#
# [69] x 的平方根
#
# 解题思路
# 1.二分查找
# y=x^2, (x > 0):抛物线，在y轴右侧单调递增, x的值在0-y之间，0和y就是上下界
# https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/
# 2.牛顿迭代法
# 思想就是通过公式逐步收敛到开根号的结果
# @lc code=start
# class Solution(object):
#     def mySqrt(self, x):
#         """
#         :type x: int
#         :rtype: int
#         """
#         if x == 0 or x == 1:
#             return x
        
#         left , right = 0, x
#         # mid随意取值，这里为1
#         mid = 1
#         while left < right:
#             #防止中间值计算越界
#             # mid = left + (right - left)//2
#             # left + right + 1  加1的目的是避免掉入中值以下导致无限循环
#             mid = (left + right + 1) / 2
#             # mid过大，把查找范围减少，由于是整形，直接减一
#             if mid * mid > x:
#                 right = mid - 1 
#             else:
#                 left = mid
        
#         return int(right)

class Solution:
    def mySqrt(self, x):
        r = x
        while r * r > x:
            r = (r + x/r) / 2
        return r




    
# @lc code=end

