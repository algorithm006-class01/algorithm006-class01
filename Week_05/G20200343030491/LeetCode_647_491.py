class Solution:
    def countSubstrings(self, s: str) -> int:
        if not str: return 0
        count = 0
        for i in range(2*len(s)-1):
            if i%2 == 0:
                left, right = i//2, i//2
            else:
                left, right = i//2, i//2 + 1
                
            while left >=0 and right <=len(s)-1 and s[left] == s[right]:
                count += 1
                left -= 1
                right += 1
                
        return count


class Solution:
    def countSubstrings(self, s: str) -> int:
        if not str: return 0
        n = len(s)
        dp = [[False] * n for _ in range(n) ]
        count = 0
        for j in range(0,n):
            for i in range(j,-1,-1):
                if s[i]==s[j] and (j-i<2 or dp[i+1][j-1]):
                    dp[i][j] = True
                    count += 1
                    
        return count