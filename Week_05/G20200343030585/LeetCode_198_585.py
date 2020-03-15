#
# @lc app=leetcode.cn id=198 lang=python
#
# [198] 打家劫舍
#
# 解题思路
# 1.DP
#   1.subproblem 求更小数组里面的最大值
#   2.状态数组定义   
#      dp = [0][1] 0为不偷，1为偷两种情况
#   2.DP方程 
#       dp[i][0] = max(dp[i-1][0], dp[i-1][1])
#       dp[i][1] = dp[i-1][0] + nums[i]
# 2.DP
#   1.状态数组定义
#       dp = [0] 偷和不偷两种情况的最大值
#   2.DP方程
#       dp[i] = max(dp[i-1], dp[i-2] + nums[i])

# @lc code=start
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        preMax = 0
        curMax = 0
        
        for i in range(len(nums)):
            temp = curMax
            curMax = max(preMax + nums[i], curMax)
            preMax = temp
            
        return curMax
    
    
# class Solution(object):
#     def rob(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: int
#         """
#         n = len(nums)

#         if not nums:
#             return 0
#         if n == 1:
#             return nums[0]
        
#         dp = [0] * n
#         dp[0] = nums[0]
#         dp[1] = max(dp[0], nums[1])
#         for i in range(2, n):
#             dp[i] = max(dp[i-1], dp[i-2] + nums[i])
            
#         return dp[-1]
        
        


# class Solution(object):
#     def rob(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: int
#         """
        
#         if len(nums) == 0:
#             return 0

#         n = len(nums)
#         # 0,1 0为不偷的列 1为偷的列
#         dp = [[0] * 2 for _ in range(n)]
#         dp[0][0] = 0
#         dp[0][1] = nums[0]
        
#         for i in range(1,len(nums)):
#             # 我这一次不偷就可以记录上一次偷的最大值
#             dp[i][0] = max(dp[i-1][0], dp[i-1][1])
#             dp[i][1] = dp[i-1][0] + nums[i]
            
#         return max(dp[n-1][0], dp[n-1][1])
        
        
        
# @lc code=end

