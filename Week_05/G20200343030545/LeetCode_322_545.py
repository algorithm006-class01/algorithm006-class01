"""
    给定不同面额的硬币 coins 和一个总金额 amount。
    编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

    示例 1:
        输入: coins = [1, 2, 5], amount = 11
        输出: 3
        解释: 11 = 5 + 5 + 1

    示例 2:
        输入: coins = [2], amount = 3
        输出: -1
"""
from functools import lru_cache
from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        return self.recursive(coins, amount)

    @classmethod
    def recursive(cls, coins: List[int], amount: int) -> int:
        @lru_cache(None)
        def helper(amt):
            # terminator
            if amt < 0:
                return -1
            if amt == 0:
                return 0

            res = float("inf")
            # process
            for coin in coins:
                sub_problem = helper(amt - coin)
                if sub_problem == -1:
                    continue
                res = min(res, sub_problem + 1)
            return res if res != float("inf") else -1

        return helper(amount)


print(Solution().coinChange([1, 2, 5], 11))
