"""
    给定一个非负整数数组，你最初位于数组的第一个位置。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    判断你是否能够到达最后一个位置。

    示例 1:
        输入: [2,3,1,1,4]
        输出: true
        解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。

    示例 2:
        输入: [3,2,1,0,4]
        输出: false
        解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
"""
from functools import lru_cache
from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        return self.dp_1(nums)

    @classmethod
    def greedy(cls, nums: List[int]) -> bool:
        """
            贪心算法
                思路：
                    1、定义一个最远能跳到的位置max_i  初始值为0
                    2、循环遍历数组，当max_i大于等于i时，说明i这个位置可以到达。
                    3、可以到达的情况下，判断i+num是否大于max_i，如果大于就更新max_i
                    4、优化处理，每次循环可以判断i是否大于max_i，如果大于了，则后续的就不用走了，因为i这块已经中断了。
                时间复杂度：O(n)
                空间复杂度：O(1)
        """
        max_i = i = 0  # 表示当前能跳到的最远位置
        for i, num in enumerate(nums):
            if i <= max_i < i + num:  # 当前位置能到达， 并且 当前位置加上跳的步骤大于max_i， 就更新max_i
                max_i = i + num
            if max_i < i:
                return False
        return max_i >= i

    @classmethod
    def dp_1(cls, nums: List[int]) -> bool:
        """
            动态规划：
                定义dp数组 dp[i]表示从下标为0 到i是否可达
                状态转移方程：
                    dp[i] = dp[j] && nums[j]+j>=i   i [1, nums_len] j [0,i]
        """
        nums_len = len(nums)
        dp = [False] * nums_len
        dp[0] = True

        for i in range(1, nums_len):
            for j in range(0, i):
                if dp[j] and nums[j] + j >= i:
                    dp[i] = True
                    break
        return dp[nums_len - 1]

    @classmethod
    def recursive(cls, nums: List[int]) -> bool:
        """
             回溯 枚举第一个位置跳到最后一个位置的的方法，可以看出如果第一个可以到第二个，那么就可以简化成从第二个到达最后一个的，分解成子问题，
             使用lru_cache，来保存重复结果，避免重复计算。
             时间复杂度：O(n^2)
             空间复杂度：O(2n)
        """
        nums_len = len(nums)

        @lru_cache(None)
        def helper(index):
            # terminator
            if index == nums_len - 1:
                return True

            # process
            furthest = min(nums[index] + index, nums_len - 1)
            for i in range(index + 1, furthest + 1):
                if helper(i):
                    return True

            return False

        return helper(0)
