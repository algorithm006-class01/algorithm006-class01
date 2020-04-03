#
# @lc app=leetcode.cn id=818 lang=python3
#
# [818] 赛车
#

# @lc code=start
class Solution:
    def racecar(self, target: int) -> int:
        dp = [float('inf')] * (target + 1)

        for i in range(1, target + 1):
            k = 1 # A的次数
            pos = 1

            while pos < i:  # pos < target
                q = 0 # R过一次后A的次数
                while ((1 << q) - 1) < pos:
                    dp[i] = min(dp[i], k+1+q+1+dp[i-(pos-((1 << q) - 1))])
                    q += 1
                k += 1
                pos = (1 << k) - 1
            
            if i == pos: # pos == target
                dp[i] = k
            else: # pos > target
                dp[i] = min(dp[i], k + 1 + dp[pos-i])
        
        return dp[target]


        
# @lc code=end

