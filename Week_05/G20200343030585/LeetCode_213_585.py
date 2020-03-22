#
# @lc app=leetcode.cn id=213 lang=python
#
# [213] 打家劫舍 II
#
# 解题思路
# 1.DP
#   1.subproblem 类似I的情况，遇到每家都可以打劫和不打劫一家
#   最大值是打劫和不打劫中的最大值
#   2.DP数组 
#       1.这里只需要上一次的最大值，和前一次的最大值，就不需要数组 
#       2.特殊的地方是，这里最后一家和第一家只能选一个，那么就存在两次
#       处理，第一次只取第一家的，第二次只取最后一家的
#   3.DP方程
#       cur = max(cur, prev+num[i]) cur是上一次的最大值，prev为前一次的最大值

# @lc code=start
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        # 0,1 0为不偷的列 1为偷的列
        def _rob(nums):
            prev = 0
            cur = 0

            for num in nums:
                # 我这一次不偷就可以记录上一次偷的最大值
                cur, prev = max(cur, prev + num), cur
            
            return cur

        return max(_rob(nums[:-1]), _rob(nums[1:])) if len(nums) != 1 else nums[0]
        
        
        

# class Solution(object):
#     def rob(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: int
#         """
#         if len(nums) == 0:
#             return 0
#         if len(nums) == 1:
#             return nums[0]

#         n = len(nums)
#         # 0,1 0为不偷的列 1为偷的列
#         dp = [[0] * 2 for _ in range(n)]
#         dp[0][0] = 0
#         dp[0][1] = nums[0]
        
#         for i in range(1,len(nums)):
#             # 我这一次不偷就可以记录上一次偷的最大值
#             dp[i][0] = max(dp[i-1][0], dp[i-1][1])
#             if i != n - 1:
#                 dp[i][1] = dp[i-1][0] + nums[i]

#         dp1 = [[0] * 2 for _ in range(n)]
#         dp1[n-1][0] = 0
#         dp1[n-1][1] = nums[n-1]
#         for i in range(n-2, -1, -1):
#             # 我这一次不偷就可以记录上一次偷的最大值
#             dp1[i][0] = max(dp1[i+1][0], dp1[i+1][1])
#             if i != 0:
#                 dp1[i][1] = dp1[i+1][0] + nums[i]

#         return max(dp[n-1][0], dp[n-1][1], dp1[0][0], dp1[0][1])
# @lc code=end

