"""
    你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
    这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
    给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

    示例 1:

        输入: [2,3,2]
        输出: 3
        解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。

    示例 2:
        输入: [1,2,3,1]
        输出: 4
        解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
             偷窃到的最高金额 = 1 + 3 = 4 。
"""
from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        return self.dp_1(nums)

    @classmethod
    def dp_1(cls, nums: List[int]) -> int:
        """
            由于第一个房子和最后一个房子是相邻的，所以能偷的最大值就是
             max( 开始偷第一个房子的最大金额nums[1:] ， 开始偷最后一个房子的最大金额nums[:n-1])
            状态转移方程
                dp[i] 表示第i个房子能偷的最大金额
                dp[i] = max(dp[i-1], dp[i-2] + num[i])
        """

        def dp(params: List[int]) -> int:
            params_len = len(params)
            res = 0
            if params:
                if params_len == 1:
                    return params[0]

                dp_ = [0] * params_len
                dp_[0] = params[0]

                res = dp_[1] = max(params[0], params[1])

                for index in range(2, params_len):
                    dp_[index] = max(dp_[index - 1], dp_[index - 2] + params[index])
                    res = max(res, dp_[index])
            return res

        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]

        return max(dp(nums[1:]), dp(nums[:len(nums) - 1]))
