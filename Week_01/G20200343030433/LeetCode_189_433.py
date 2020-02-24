#
# @lc app=leetcode.cn id=189 lang=python3
#
# [189] 旋转数组
#

# @lc code=start
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k % n
        nums[:] = nums[n-k:] + nums[:n-k]
        
        """
        for i in range(len(nums)):
            if i < k:            
                result.append(nums[len(nums)-k + i])
                
            if i >= k:
                result.append(nums[i-k])
        return result
# @lc code=end

