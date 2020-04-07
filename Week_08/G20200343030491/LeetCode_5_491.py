class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s: return ''
        N = 2*len(s) - 1
        maxVal = 0
        res = ''
        
        for i in range(N):
            left = i//2
            right = i//2 + i%2
            
            while 0<=left<len(s) and 0<=right<len(s):
                if s[left] == s[right]:
                    left -= 1
                    right += 1
                else:
                    break
                    
            if maxVal < right - left - 1:
                maxVal = right -left - 1
                res = s[left+1:right]
        
        return res

class Solution:
    def longestPalindrome(self, s: str) -> str:
        dp = [[False]*len(s) for _ in range(len(s))]
        maxLen = 0
        res = ''
        
        for i in range(len(s)):
            for j in range(i,-1,-1):
                if s[i]==s[j] and (i-j<2 or dp[j+1][i-1]):
                    dp[j][i] = True
                    if maxLen<i-j+1:
                        maxLen=i-j+1
                        res = s[j:i+1]
        return res