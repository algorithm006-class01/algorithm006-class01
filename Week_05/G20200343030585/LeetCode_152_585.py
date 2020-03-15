#
# @lc app=leetcode.cn id=152 lang=python
#
# [152] 乘积最大子序列
#
# 解题思路
# 1.动态规划
#   1.当前值肯定和上一个的值乘或不乘，乘或不乘产生一个最大值or最小值
#   2.当当前值小于0时，为最小值，相反的情况为最大值

# @lc code=start
class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        if not nums:
            return 0 
        
        n = len(nums)
        max_mul = nums[0]
        imax = 1
        imin = 1
        for i in range(0, n):
            if nums[i] < 0:
                temp = imax
                imax = imin
                imin = temp
            imax = max(imax * nums[i], nums[i])
            imin = min(imin * nums[i], nums[i])
            max_mul = max(max_mul, imax)

        return max_mul
        
# @lc code=end

