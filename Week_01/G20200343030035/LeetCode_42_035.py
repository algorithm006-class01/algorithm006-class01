# LeetCode #42 接雨水
# 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。


class Solution:
    def trap(self, block):
        if not block or len(block) < 3:
            return 0
        sum = 0
        left, right = 0, len(block) - 1
        l_max, r_max = block[left], block[right]
        while left < right:
            l_max, r_max = max(block[left], l_max), max(block[right], r_max)
            if l_max <= r_max:
                sum += l_max - block[left]
                left += 1
            else:
                sum += r_max - block[right]
                right -= 1
        return sum