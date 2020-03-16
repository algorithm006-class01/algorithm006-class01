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
        return self.dp_1(coins, amount)

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

    @classmethod
    def dp_1(cls, coins: List[int], amount: int) -> int:
        """
            动态递归
            dp[i] 表示总金额为i时的最优解法
            例如 当i=11 硬币分别为[1,2,5]时 dp[11] = min( dp[11-1] ,dp[11-2], dp[11-5])+1
            所以状态转移方程为：
                dp[i] = min([dp[i-coin] for coin in coins if coin<=i]) +1
            状态转移方程加了一个i>=coin的条件，如果coin>i则没必要往下找了

            时间复杂度：O(an)  a代表amount n代表硬币的个数
            空间复杂度：O(a)

        """
        dp = [float("inf") if i else 0 for i in range(amount + 1)]
        for i in range(1, amount + 1):
            dp[i] = min([dp[i - coin] if i >= coin else float("inf") for coin in coins]) + 1
        return -1 if dp[amount] == float("inf") else dp[amount]

    @classmethod
    def bfs(cls, coins: List[int], amount: int) -> int:
        pass
