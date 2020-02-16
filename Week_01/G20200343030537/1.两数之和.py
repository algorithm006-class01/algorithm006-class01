#
# @lc app=leetcode id=1 lang=python3
#
# [1] Two Sum
#
from typing import List
# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if len(nums) <= 1:
            return False
        hashmap = {}
        for i, num in enumerate(nums):
            if num in hashmap:
                return [hashmap[num], i]
            else:
                hashmap[target - num] = i
# @lc code=end

