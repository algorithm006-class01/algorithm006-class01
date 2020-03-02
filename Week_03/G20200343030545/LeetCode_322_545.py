"""
    给定不同面额的硬币 coins 和一个总金额 amount。
    编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
    如果没有任何一种硬币组合能组成总金额，返回 -1。

    示例 1:
        输入: coins = [1, 2, 5], amount = 11
        输出: 3
        解释: 11 = 5 + 5 + 1

    示例 2:
        输入: coins = [2], amount = 3
        输出: -1
    说明:
        你可以认为每种硬币的数量是无限的。

    https://leetcode-cn.com/problems/coin-change
"""
from typing import List, Dict


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        return self.recursive_use_memo(coins, amount, {})

    @classmethod
    def recursive(cls, coins: List[int], amount: int) -> int:
        """
            时间复杂度: O(k*n^k)
        """
        if amount == 0:
            return 0
        if amount < 0:
            return -1

        res = float("inf")

        for coin in coins:
            sub_problem = cls.recursive(coins, amount - coin)
            if sub_problem == -1:
                continue
            res = min(res, sub_problem + 1)
        return res if res != float("inf") else -1

    @classmethod
    def recursive_use_memo(cls, coins: List[int], amount: int, memo: Dict):
        """
            时间复杂度：O(kn)
        """
        if amount in memo:
            return memo[amount]

        if amount == 0:
            return 0

        if amount < 0:
            return -1

        res = float("inf")

        for coin in coins:
            sub_problem = cls.recursive_use_memo(coins, amount - coin, memo)
            if sub_problem == -1:
                continue

            res = min(res, sub_problem + 1)

        memo[amount] = res if res != float("inf") else -1
        return memo[amount]


if __name__ == '__main__':
    print(Solution.recursive([1, 2, 2], 11))
