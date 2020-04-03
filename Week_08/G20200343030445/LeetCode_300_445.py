#
# @lc app=leetcode.cn id=300 lang=python3
#
# [300] 最长上升子序列
#

# @lc code=start
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        dp = [0] * len(nums)
        dp[0] = 1
        for i in range(1, len(nums)):
            dp[i] += 1
            maxl = 0
            for j in range(i-1, -1, -1):
                if nums[j] < nums[i]:
                    if maxl < dp[j]:
                        maxl = dp[j]
            dp[i] += maxl
        # print(dp)
        return max(dp)
        
# @lc code=end

