#
# @lc app=leetcode.cn id=91 lang=python
#
# [91] 解码方法
# 
# 解题思路
# 1.动态规划
#   1.subproblem 
#    dp[i] = dp[i-2] + dp[i-1]
#       1.任何字符为'0'返回0，不能解码
#       2、前面两个数字存在于字典中，就是前面两种情况的和 dp[i] += dp[i-2]
#       3.如果前面两个不在字典中，就是dp[i] += dp[i-1]
#   2.dp数组
#   3.dp方程
#    dp[i] = dp[i-2] + dp[i-1]


# @lc code=start
class Solution(object):
    def numDecodings(self, s): 
        if not s:
            return 0

        dp = [0 for x in range(len(s) + 1)] 
        
        # base case initialization
        dp[0] = 1 
        dp[1] = 0 if s[0] == "0" else 1   #(1)

        for i in range(2, len(s) + 1): 
            # One step jump
            if 0 < int(s[i-1:i]) <= 9:    #(2)
                dp[i] += dp[i - 1]
            # Two step jump
            if 10 <= int(s[i-2:i]) <= 26: #(3)
                dp[i] += dp[i - 2]
        return dp[len(s)]


# @lc code=end

