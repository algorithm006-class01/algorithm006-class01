#
# @lc app=leetcode id=283 lang=python3
#
# [283] Move Zeroes
#
# https://leetcode.com/problems/move-zeroes/description/
#
# algorithms
# Easy (56.24%)
# Likes:    2955
# Dislikes: 99
# Total Accepted:    622.3K
# Total Submissions: 1.1M
# Testcase Example:  '[0,1,0,3,12]'
#
# Given an array nums, write a function to move all 0's to the end of it while
# maintaining the relative order of the non-zero elements.
# 
# Example:
# 
# 
# Input: [0,1,0,3,12]
# Output: [1,3,12,0,0]
# 
# Note:
# 
# 
# You must do this in-place without making a copy of the array.
# Minimize the total number of operations.
# 
#

# @lc code=start
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # 自己写的 感觉逻辑有点冗余
        # none_zero_index = 0
        # for index in range(len(nums)):
        #     if nums[index] and not nums[none_zero_index]:
        #         nums[index], nums[none_zero_index] = nums[none_zero_index], nums[index]
        #         none_zero_index += 1
        #     elif nums[none_zero_index]:
        #         none_zero_index += 1

        # discuss 里的高分代码
        zero = 0
        for index in range(len(nums)):
            if nums[index]:
                nums[zero], nums[index] = nums[index], nums[zero]
                zero += 1

# @lc code=end

