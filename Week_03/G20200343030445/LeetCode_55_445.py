#
# @lc app=leetcode.cn id=55 lang=python3
#
# [55] 跳跃游戏
#

# @lc code=start
class Solution:
    def canJump(self, nums: List[int]) -> bool:

        # greedy
        pos = len(nums) - 1
        for i in range(len(nums)-1, -1, -1):
            if i + nums[i] >= pos:
                pos = i
        return pos == 0
# @lc code=end

