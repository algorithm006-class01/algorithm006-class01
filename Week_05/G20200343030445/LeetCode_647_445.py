#
# @lc app=leetcode.cn id=647 lang=python3
#
# [647] 回文子串
#

# @lc code=start
class Solution:
    def countSubstrings(self, s: str) -> int:
        n = len(s)
        dp = [[0] * n for _ in range(n)]
        count = 0
        for i in range(n):
            for j in range(i, -1, -1):
                if s[i] == s[j] and (i - j < 2 or dp[j+1][i-1]):
                    dp[j][i] = True
                    count += 1
        return count

        
# @lc code=end

