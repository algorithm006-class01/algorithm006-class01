#
# @lc app=leetcode.cn id=69 lang=python3
#
# [69] x 的平方根
#
# https://leetcode-cn.com/problems/sqrtx/description/
#
# algorithms
# Easy (37.61%)
# Likes:    333
# Dislikes: 0
# Total Accepted:    107.3K
# Total Submissions: 285.3K
# Testcase Example:  '4'
#
# 实现 int sqrt(int x) 函数。
# 
# 计算并返回 x 的平方根，其中 x 是非负整数。
# 
# 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
# 
# 示例 1:
# 
# 输入: 4
# 输出: 2
# 
# 
# 示例 2:
# 
# 输入: 8
# 输出: 2
# 说明: 8 的平方根是 2.82842..., 
# 由于返回类型是整数，小数部分将被舍去。
# 
# 
#

# @lc code=start
class Solution:
    def mySqrt(self, x: int) -> int:
        if x <= 1:
            return x
        start, end = 1, x 
        while start + 1 < end:
            mid = start + (end - start) // 2
            if mid == x // mid:
                return mid
            if mid < x // mid:
                start = mid
            else:
                end = mid
        if end * end> x // end:
            return start
        return end

# @lc code=end

