"""
    你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
    影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
    给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

    示例 1:
        输入: [1,2,3,1]
        输出: 4
        解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
             偷窃到的最高金额 = 1 + 3 = 4 。

    示例 2:
        输入: [2,7,9,3,1]
        输出: 12
        解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
             偷窃到的最高金额 = 2 + 9 + 1 = 12 。
"""
from functools import lru_cache
from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        return self.recursive(nums)

    @classmethod
    def recursive(cls, nums: List[int]) -> int:
        """:argument
            递归的写法
                加上了 缓存
            时间复杂度：O(n)
            空间复杂度：O(n)
        """
        nums_len = len(nums)

        @lru_cache(None)
        def helper(index):
            # terminator
            if index < 0:
                return 0
            if index == 0:
                return nums[0]

            choose_i = helper(index - 2) + nums[index]
            not_choose_i = helper(index - 1)
            return max(choose_i, not_choose_i)

        return helper(nums_len - 1)

    @classmethod
    def dp_1(cls, nums: List[int]) -> int:
        """
            状态转移方程：
                dp[i][0] 表示下标为i的房子不偷时 能偷到的最大金额
                dp[i][1] 表示下表为i的房子偷时 能偷到的最大金额

            所以状态转移方程是：
                dp[i][0] = max(dp[i-1][0], dp[i-1][1]) # 当下标为i的房子不偷，则取i-1房子偷和不偷的最大值
                dp[i][1] = dp[i-1][0] + nums[i]     #当下标为i的房子偷时，i-1肯定不能偷了，但是可以加上nums[i]
            时间复杂度：O(n)
            空间复杂度：O(n)
        """
        res = 0
        if nums:
            nums_length = len(nums)
            dp = [[0] * 2 for i in range(nums_length)]
            dp[0][1] = nums[0]  # 表示第一个房子偷时的能带来的最大金额¬

            for index in range(1, nums_length):
                dp[index][0] = max(dp[index - 1][0], dp[index - 1][1])
                dp[index][1] = dp[index - 1][0] + nums[index]
            res = max(dp[len(nums) - 1][1], dp[len(nums) - 1][0])
        return res

    @classmethod
    def dp_2(cls, nums: List[int]):
        """
            a[i] 表示 偷下标为i的房子的最大收益
            状态转移方程：
                a[i] = max(a[i-1] , a[i-2]+nums[i])
            时间复杂度：O(n)
            空间复杂度：O(n)
        """
        res = 0
        if nums:
            nums_len = len(nums)
            if nums_len == 1:
                return nums[0]
            dp = [0] * nums_len

            for index in range(2, nums_len):
                dp[index] = max(dp[index - 1], dp[index - 2] + nums[index])
                res = max(dp[index], res)
        return res

    @classmethod
    def dp_3(cls, nums: List[int]) -> int:
        """
            用两个变量来存当前的最大值 和 上一个的最大值
            时间复杂度：O(n)
            空间复杂度：O(1)
        """
        curr_max = 0  # 当前最大值
        prev_max = 0  # 上一个最大值

        for num in nums:
            tmp_max = curr_max
            curr_max = max(prev_max + num, curr_max)
            prev_max = tmp_max
        return curr_max


if __name__ == '__main__':
    print(Solution.recursive([1, 2, 3, 1]))
