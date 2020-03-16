#
# @lc app=leetcode.cn id=32 lang=python3
#
# [32] 最长有效括号
#

# @lc code=start
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        n = len(s)
        dp = [False] * n
        stack = []
        for i in range(n):
            if s[i] == "(":
                stack.append(i)
            elif stack:
                dp[stack.pop()] = True
                dp[i] = True
                    
        count = 0
        max_count = 0
        for i in dp:
            if i:
                count += 1
            else:
                max_count = max(max_count, count)
                count = 0
        return max(max_count, count)

                 

# @lc code=end

