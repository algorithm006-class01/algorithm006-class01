# 青蛙过河
class Solution:
    def canCross(self, stones):
        dp = dict()

        for s in stones:
            dp.setdefault(s,set())
        
        dp.get(0).add(0)

        for s in stones:
            for pre_step in dp.get(s):
                for step in [pre_step-1,pre_step,pre_step+1]:
                    if step > 0 and (s+step) in dp:
                        dp.get(s+step).add(step)
        return len(dp.get(stones[-1])) > 0


# 最长有效括号
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        n = len(s)
        if not s: return 0
        
        dp = [0]*n
        res = 0
        for i in range(n):
            if i > 0 and s[i] == ')':
                if s[i-1] == '(':
                    dp[i] = dp[i-1] + 2
                elif s[i-1] == ')' and i - dp[i-1] -1 >= 0 and s[i-dp[i-1]-1] == '(':
                    dp[i] = dp[i-1]+2+dp[i-dp[i-1]-2]
                
                if dp[i] > res: res = dp[i]

        return res