#
# @lc app=leetcode.cn id=53 lang=python
#
# [53] 最大子序和
# 解题思路
# 1.暴力求解 O(N^2) 遍历所有头和尾，头和尾都要是正数
# 2.DP
#   1. 分治问题： max_sum(i) = max_sum(i-1) + nums[i]
#   2. 状态数组定义： f[i]
#   3.DP方程: f[i] = max(f[i-1], 0) + a[i] 
#   求前面的最大值，如果小于0就不要前面的值

# @lc code=start
class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        
        n = len(nums)
        max_val = nums[0]
        
        for i in range(1, n):
            if nums[i - 1] > 0:
                nums[i] += nums[i-1]
            max_val = max(max_val, nums[i])
        return max_val
                
# @lc code=end
