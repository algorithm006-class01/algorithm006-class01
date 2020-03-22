#
# @lc app=leetcode.cn id=367 lang=python
#
# [367] 有效的完全平方数
#

# @lc code=start
class Solution(object):
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num == 1 or num == 0:
            return True
        r = num/2
        x = num
        while r * r > x:
            r = (r + x/r) / 2
        return True if r * r == num else False
        
# @lc code=end

