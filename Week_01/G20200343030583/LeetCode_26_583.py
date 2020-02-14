#
# @lc app=leetcode id=26 lang=python3
#
# [26] Remove Duplicates from Sorted Array
# 1. brute force, count distinct elements, O(n)
# 2. directly s = set(nums), return len(s), list(s), but not satisfy the needs for this case

# @lc code=start
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        x = 1
        for i in range(len(nums) - 1):
            if nums[i] != nums[i+1]:
                nums[x] = nums[i+1]
                x += 1
        return x

                
# @lc code=end

