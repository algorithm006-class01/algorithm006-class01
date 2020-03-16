class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if len(s)<=1:
            return 0
        
        stack = [-1]
        maxlength = 0
        for i in range(len(s)):
            if s[i] =='(':
                stack.append(i)
            elif stack:
                stack.pop()
                if not stack:
                    stack.append(i)
                else:
                    maxlength = max(maxlength,i-stack[-1])
                
        return maxlength


class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if len(s)<=1:
            return 0
        
        s = '))' + s
        dp = [0] * len(s)
        for i in range(2,len(s)):
            if s[i] == ')':
                if s[i-1] == '(':
                    dp[i] = dp[i-2] + 2
                elif s[i-dp[i-1]-1] == '(':
                    dp[i] = dp[i-dp[i-1]-2] + 2 + dp[i-1]
                    
                    
        return max(dp)

        