#
# @lc app=leetcode.cn id=26 lang=python3
#
# [26] 删除排序数组中的重复项
#

# @lc code=start
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        ptr = 0
        ptr2 = 0
        count = 0
        while ptr < len(nums):
            curr = nums[ptr]
            count += 1
            ptr2 += 1
            
            while ptr2 < len(nums) and nums[ptr2] == curr:
                ptr2 += 1
                
            ptr += 1
            if ptr >= len(nums) or ptr2 >= len(nums):
                break
            
            nums[ptr] = nums[ptr2]
            
        return count
# @lc code=end

