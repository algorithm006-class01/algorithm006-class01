#
# @lc app=leetcode.cn id=46 lang=python3
#
# [46] 全排列
#

# @lc code=start
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        output = []
        
        def per(nums, result):
            if len(nums) == 0:
                output.append(result[:])
                return
            
            for i in range(len(nums)):
                result.append(nums[i])
                per(nums[:i] + nums[i+1:], result)
                result.pop()
                
        per(nums, [])
        return output
        
# @lc code=end

