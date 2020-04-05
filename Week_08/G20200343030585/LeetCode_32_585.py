#
# @lc app=leetcode.cn id=32 lang=python
#
# [32] 最长有效括号
# 官方题解
# https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode/
# 解题思路
# 1.动态规划
#   1.subproblem  循环匹配()括号
#   2.DP数组 与字符串长度相同
#   3.DP方程 
#   dp[i] = sum(list)


# @lc code=start
class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        if not s:
            return 0

        n = len(s)
        dp = [0] * n
        dp[0] = 0
        maxans = 0
        
        for i in range(1, n):
            if s[i] == ')':
                if s[i-1] == '(':
                    if i - 2 >= 0:
                        dp[i] = 2 + dp[i-2] 
                    else:
                        dp[i] = 2
                elif i - dp[i-1] > 0 and s[i-dp[i-1] - 1] == '(':
                    if i-dp[i-1] >= 2:
                        dp[i] = dp[i-1] + 2 + dp[i - dp[i - 1] - 2]
                    else:
                        dp[i] = dp[i-1] + 2
                maxans = max(dp[i], maxans) 
        return maxans
        
        
        
# @lc code=end

