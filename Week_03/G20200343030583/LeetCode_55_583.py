#
# @lc app=leetcode id=55 lang=python
#
# [55] Jump Game
# 1. greedy backward
# 2. greedy forward
# 3. Check if there are steps left for us to jumps every time.
# https://leetcode.com/problems/jump-game/discuss/21156/Simple-Python-solution-O(n-1)-55ms
 
# @lc code=start
# too slow
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        target_idx = len(nums) - 1
        while target_idx > 0:
            for i in range(target_idx - 1, -1,-1):
                if nums[i] >= (target_idx - i):
                    target_idx = i
                    break
                if i == 0 and target_idx > 0:
                    return False
        return True

# StefanPochmann's solution
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        goal = len(nums) - 1
        for i in range(len(nums))[::-1]:
            if i + nums[i] >= goal:
                goal = i
        return  not goal

# StefanPochmann's solution2 greedy foward
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        m = 0
        for i in range(len(nums)):
            if i > m:
                return False
            m = max(m,i+nums[i])
        return True
# Check if there are steps left for us to jumps every time.
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        stepLeft = nums[0]
        if not stepLeft and len(nums) > 1:
            return False
        for num in nums[1:-1]:
            stepLeft = max(stepLeft - 1,num)
            if not stepLeft:
                return False
        return True
# @lc code=end

