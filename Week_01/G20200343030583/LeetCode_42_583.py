#
# @lc app=leetcode id=42 lang=python
#
# [42] Trapping Rain Water
# 1. brute force O(n^2), for each bar, find left max and right max height
# 2. dynamic programming to store left max height and right max height O(n)
# 3. stack O(n)
# 4. two pointer O(n) https://leetcode.com/problems/trapping-rain-water/discuss/17554/Share-my-one-pass-Python-solution-with-explaination

# @lc code=start
# second
# class Solution(object):
#     def trap(self, height):
#         """
#         :type height: List[int]
#         :rtype: int
#         """
#         if len(height) <= 1:
#             return 0
#         left_max = [0 for i in range(len(height))]
#         right_max = [0 for j in range(len(height))]
#         left_max[0], right_max[-1] = height[0], height[len(height) - 1]
#         for i in range(1,len(height)):
#             left_max[i] = max(left_max[i - 1], height[i])
#         for j in range(len(height) - 2, -1, -1):
#             right_max[j] = max(right_max[j+1], height[j])
#         ans = 0
#         for i in range(len(height)):
#             ans += min(left_max[i],right_max[i]) - height[i]
#         return ans

# Third
# class Solution(object):
#     def trap(self, height):
#         """
#         :type height: List[int]
#         :rtype: int
#         """
#         if len(height) <= 1:
#             return 0
#         stack = []
#         ans = 0
#         for current in range(len(height)):
#             while(len(stack) != 0 and height[current] > height[stack[-1]]):
#                 h = height[stack[-1]]
#                 stack.pop()
#                 if len(stack) == 0:
#                     break
#                 stack_top = stack[-1]
#                 distance = current - stack_top - 1
#                 boundary_height = min(height[stack_top],height[current]) - h
#                 ans += distance * boundary_height
            
#             stack.append(current)
        
#         return ans

# Fourth
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height) <= 1:
            return 0
        ans = 0
        left = 0
        right = len(height) - 1
        left_max = height[left]
        right_max = height[right]
        while left < right:
            left_max, right_max = max(left_max,height[left]),max(right_max,height[right])
            if left_max <= right_max:
                ans += left_max - height[left]
                left += 1
            else:
                ans += right_max - height[right]
                right -= 1

        return ans
# @lc code=end

