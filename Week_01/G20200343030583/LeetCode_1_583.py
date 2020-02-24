#
# @lc app=leetcode id=1 lang=python
#
# [1] Two Sum
# 1. brute force, O(n*n)
# 2. hash table mapping, O(n)
# 3. two pointer, O(n)

# @lc code=start
# Second
# class Solution(object):
#     def twoSum(self, nums, target):
#         """
#         :type nums: List[int]
#         :type target: int
#         :rtype: List[int]
#         """
#         map = dict()
#         for i in range(len(nums)):
#             if nums[i] not in map:
#                 # because there is exactly one solution
#                 map[target - nums[i]] = i
#             else:
#                 return map[nums[i]],i
#         return -1, -1

# Third
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        nums = enumerate(nums)
        nums = sorted(nums, key = lambda x:x[1])
        i,j = 0, len(nums) - 1
        while i < j:
            if nums[i][1] + nums[j][1] < target:
                i += 1
            elif nums[i][1] + nums[j][1] > target:
                j -= 1
            else:
                return sorted([nums[i][0],nums[j][0]])
        
        return -1, -1
# @lc code=end

