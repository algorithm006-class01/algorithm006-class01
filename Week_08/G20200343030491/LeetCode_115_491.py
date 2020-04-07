class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        if not t: return 1
        if not s: return 0
        dp = [[0]*(len(s)+1) for _ in range(len(t)+1)]
        
        for k in range(len(s)+1):
            dp[0][k] = 1
        
        for i in range(1,len(t)+1):
            for j in range(1,len(s)+1):
                if t[i-1]!=s[j-1]:
                    dp[i][j] = dp[i][j-1]
                else:
                    dp[i][j] = dp[i][j-1]+dp[i-1][j-1]
            
        return dp[i][j]