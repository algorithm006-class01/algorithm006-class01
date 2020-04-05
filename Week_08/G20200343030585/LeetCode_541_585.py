#
# @lc app=leetcode.cn id=541 lang=python
#
# [541] 反转字符串 II
#

# @lc code=start
class Solution(object):
    def reverseStr(self, s, k):
        a = list(s)
        for i in range(0, len(a), 2*k):
            a[i:i+k] = reversed(a[i:i+k])
        return "".join(a)

# @lc code=end

