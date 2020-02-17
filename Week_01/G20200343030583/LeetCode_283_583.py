#
# @lc app=leetcode id=283 lang=python
#
# [283] Move Zeroes
#

# @lc code=start
# class Solution(object):
#     def moveZeroes(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: None Do not return anything, modify nums in-place instead.
#         """
#         zero_pointer = self.find_first_zero(nums)
#         for i in range(len(nums)):
#             if nums[i] != 0 and i > zero_pointer:
#                 nums[zero_pointer],nums[i] = nums[i],0
#             zero_pointer = self.find_first_zero(nums[zero_pointer + 1:])

#     def find_first_zero(self, nums):
#         i = 0
#         while nums[i] != 0:
#             i += 1
#         return i

class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        count = 0
        for i in range (len(nums)):
            if nums[i] != 0:
                nums[count] = nums[i]
                count += 1
        while count < len(nums):
            nums[count] = 0
            count += 1




# @lc code=end

