#
# @lc app=leetcode.cn id=42 lang=python3
#
# [42] 接雨水
#

# @lc code=start
class Solution:
    def trap(self, height: List[int]) -> int:
        output = 0
        stack = []
        ptr = 0
        while ptr < len(height):
            while len(stack) > 0 and height[ptr] > height[stack[-1]]:
                tmp = height[stack[-1]]
                stack.pop()
                if len(stack)==0:
                    break
                distance = ptr - stack[-1] - 1
                output += distance * (min(height[stack[-1]], height[ptr]) - tmp)
            stack.append(ptr)
            ptr += 1
        return output

        
# @lc code=end

