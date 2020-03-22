#
# @lc app=leetcode id=45 lang=python
#
# [45] Jump Game II
# use greedy

# @lc code=start
# TLE!! because nums[i] may be very large
from collections import deque
class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        queue = deque([(0,0)])
        while queue:
            index, step = queue.popleft()
            if index == len(nums) - 1:
                return step
            if index > len(nums) - 1:
                continue
            for i in range(1, nums[index] + 1):
                queue.append((index + i,step + 1))
        return -1

# divide into segment
# Solution 3: Greedy
# The range of the current jump is [begin, end], 
# the furthest is the furthest point all [begin, end] can reach. When i == end, then trigger another jump
class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n,start,end,maxend = len(nums), 0 ,0 ,0
        step = 0
        while end < n - 1:
            step += 1
            maxend = end + 1
            for i in range(start,end+1):
                if i + nums[i] > n - 1:
                    return step
                maxend = max(maxend,i+nums[i])
            start,end = end + 1, maxend
        return step
# @lc code=end

