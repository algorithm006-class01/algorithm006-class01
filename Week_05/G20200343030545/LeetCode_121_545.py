"""
    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
    注意你不能在买入股票前卖出股票。

    示例 1:
        输入: [7,1,5,3,6,4]
        输出: 5
        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
             注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。

    示例 2:
        输入: [7,6,4,3,1]
        输出: 0
        解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
"""
from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        return self.dp_2(prices)

    @classmethod
    def dp_2(cls, prices: List[int]) -> int:
        """
            用两个变量来代替数组
            时间复杂度：O(n)
            空间复杂度：O(1)

        """
        max_profit, min_price = 0, float("int")
        for price in prices:
            min_price = min(price, min_price)
            max_profit = max(max_profit, price - min_price)
        return max_profit

    @classmethod
    def dp_1(cls, prices: List[int]) -> int:
        """
            dp 数组 dp[i] 表示第i 天的最大收益
            dp[i] = max(dp[i-1], prices[i] - min_prices)
        """
        max_profit = 0
        if prices:
            min_prices = float("inf")
            prices_len = len(prices)
            dp = [0] * (prices_len + 1)  # 浪费一个空间好去算最大收益
            max_profit = 0

            for index in range(prices_len):
                min_prices = min(min_prices, prices[index])

                dp[index] = max(dp[index - 1], prices[index] - min_prices)
                max_profit = max(max_profit, dp[index])
        return max_profit
