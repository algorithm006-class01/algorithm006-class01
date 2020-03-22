"""
    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

    示例 1:
        输入:
            [7,1,5,3,6,4]
        输出:
            7
        解释:
            在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
            随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。

    示例 2:
        输入:
            [1,2,3,4,5]
        输出:
            4
        解释:
            在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
            注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
            因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。

    示例 3:
        输入: [7,6,4,3,1]
        输出: 0
        解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
"""
from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        return self.greedy(prices)

    @classmethod
    def greedy(cls, prices: List[int]) -> int:
        """
            时间复杂度：O(n)
            空间复杂度：O(1)
        """
        profit = 0

        for index in range(1, len(prices)):
            if prices[index] > prices[index - 1]:
                profit += prices[index] - prices[index - 1]
        return profit

    @classmethod
    def recursive(cls, prices: List[int], index: int = 0) -> int:
        """
            时间复杂度：O(n^n)
            空间复杂度：O(n)
        """
        if index >= len(prices):
            return 0

        max_profit = 0
        for i in range(index, len(prices)):
            for j in range(i + 1, len(prices)):
                if prices[j] > prices[i]:
                    profit = cls.recursive(prices, j + 1) + prices[j] - prices[i]
                    max_profit = max(profit, profit)

        return max_profit

        # if index >= len(prices):
        #     return 0
        #
        # max_profit = 0
        #
        # for i in range(index, len(prices)):
        #     tmp_max_profit = 0
        #     for j in range(i + 1, len(prices)):
        #         if prices[j] > prices[i]:
        #             profit = cls.recursive(prices, j + 1) + prices[j] - prices[i]
        #             tmp_max_profit = max(tmp_max_profit, profit)
        #     max_profit = max(max_profit, tmp_max_profit)
        # return max_profit


if __name__ == '__main__':
    print(Solution.recursive([7, 1, 5, 6, 3, 4]))
