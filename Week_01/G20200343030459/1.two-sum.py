#
# @lc app=leetcode id=1 lang=python3
#
# [1] Two Sum
#
# https://leetcode.com/problems/two-sum/description/
#
# algorithms
# Easy (45.08%)
# Likes:    13561
# Dislikes: 494
# Total Accepted:    2.6M
# Total Submissions: 5.7M
# Testcase Example:  '[2,7,11,15]\n9'
#
# Given an array of integers, return indices of the two numbers such that they
# add up to a specific target.
# 
# You may assume that each input would have exactly one solution, and you may
# not use the same element twice.
# 
# Example:
# 
# 
# Given nums = [2, 7, 11, 15], target = 9,
# 
# Because nums[0] + nums[1] = 2 + 7 = 9,
# return [0, 1].
# 
# 
#

# @lc code=start
"""
    双指针算法(无法使用因为会打乱 indice 顺序)
"""
# class Solution:
#     def twoSum(self, nums: List[int], target: int) -> List[int]:
#         if not nums:
#             return [-1, -1]
#         nums.sort()
#         left = 0
#         right = len(nums) - 1
#         while left < right:
#              if nums[left] + nums[right] == target:
#                  return [left, right]
#              elif nums[left] + nums[right] > target:
#                  right -= 1
#              else:
#                  left += 1
#         return None
# @lc code=end


"""
    用字典记录的做法
"""
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if not nums or len(nums) == 1:
            return [-1, -1]
        hash = {}
        for index in range(len(nums)):
            num = nums[index]
            if num in hash:
                return [hash[num], index]
            hash[target - num] = index
        return [-1, -1]
