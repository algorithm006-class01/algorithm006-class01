#
# @lc app=leetcode id=33 lang=python
#
# [33] Search in Rotated Sorted Array
#

# @lc code=start
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left = 0
        right = len(nums) - 1
        if target not in nums:
            return -1
        while left <= right:
            mid = left + (right - left) / 2
            if nums[mid] == target:
                break
            if nums[left] <= nums[mid]:
                if target >= nums[mid]:
                    left = mid + 1
                else:
                    if target >= nums[left]:
                        right = mid - 1
                    else:
                        left = mid + 1
            else:
                if target >= nums[mid]:
                    if target >= nums[left]:
                        right = mid - 1
                    else:
                        left = mid + 1
                else:
                    right = mid - 1
        
        return mid
        
# use xor to check how to move next step
# https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14419/Pretty-short-C%2B%2BJavaRubyPython
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left = 0
        right = len(nums) - 1
        if target not in nums:
            return -1
        while left <= right:
            mid = left + (right - left) / 2
            if nums[mid] == target:
                break
            if (nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]):
                left = mid + 1
            else:
                right = mid
        
        return mid

# @lc code=end

