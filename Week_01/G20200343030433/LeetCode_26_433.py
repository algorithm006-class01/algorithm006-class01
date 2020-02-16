#
# @lc app=leetcode.cn id=26 lang=python3
#
# [26] 删除排序数组中的重复项
#

# @lc code=start
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:
            return 0
        first_point = 0
        for sencond_point in range(1, len(nums)):
            if nums[sencond_point] != nums[first_point]:
                first_point += 1
                nums[first_point] = nums[sencond_point]
        print(first_point)    
        return first_point + 1
# @lc code=end

