class Solution:
    def longestValidParentheses(self, s: str) -> int:
        maxlen = 0
        s = "))"+s
        dp = [0]*len(s)
        for i in range(2,len(s)):
            if s[i]==')':
                if s[i-1]=='(': 
                    dp[i] = dp[i-2]+2
                elif s[i-1]==')':
                    if s[i-dp[i-1]-1] == '(':
                        dp[i] = dp[i-1]+2 + dp[i-dp[i-1]-2]
                    
            maxlen = max(maxlen,dp[i])
            
        return maxlen

class Solution:
    def longestValidParentheses(self, s: str) -> int:
        res = 0
        stack = []
        stack.append(-1)
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                stack.pop()
                if len(stack) == 0:
                    stack.append(i)
                else:
                    res = max(res, i-stack[-1])
        return res