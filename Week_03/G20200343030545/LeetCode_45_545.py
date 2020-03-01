"""
    给定一个非负整数数组，你最初位于数组的第一个位置。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    你的目标是使用最少的跳跃次数到达数组的最后一个位置。

    示例:
        输入: [2,3,1,1,4]
        输出: 2
        解释: 跳到最后一个位置的最小跳跃数是 2。
             从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。

    说明:
        假设你总是可以到达数组的最后一个位置。
"""
from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        """
            时间复杂度：O(n)
            空间复杂度：O(1)
            每次找到能跳到最远的位置
            如果循环下标到达这个位置，则更新步数和边界值

        """
        steps = end = max_area = 0

        for index, num in enumerate(nums[:-1]):  # 因为这个里index是从0开始的，上来肯定先加1，如果num不是到最后一个停止，就会导致结果多加1
            max_area = max(max_area, nums[index] + index)

            if end == index:
                steps += 1
                end = max_area
        return steps


if __name__ == '__main__':
    print(Solution().jump([2, 3, 1, 1, 4]))
