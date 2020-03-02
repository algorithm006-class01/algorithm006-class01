# 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
# 
#  设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 
# 
#  注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
# 
#  示例 1: 
# 
#  输入: [7,1,5,3,6,4]
# 输出: 7
# 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
#      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
#  
# 
#  示例 2: 
# 
#  输入: [1,2,3,4,5]
# 输出: 4
# 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
#      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
#      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
#  
# 
#  示例 3: 
# 
#  输入: [7,6,4,3,1]
# 输出: 0
# 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
#  Related Topics 贪心算法 数组
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        #return violence(prices, 0)
        if len(prices) == 0:
            return 0
        max_profit = 0
        current_low_price = prices[0]
        for index, price in enumerate(prices):
            if index == 0:
                continue
            if price < prices[index - 1]:
                max_profit += prices[index - 1] - current_low_price
                current_low_price = price
            elif index == prices.__len__() - 1:
                max_profit += price - current_low_price
        return max_profit



def violence(prices: List[int], s_index):
    l = prices.__len__()
    if s_index > l:
        return 0
    final_max = 0
    for i in range(s_index, l):
        max_profit = 0
        for k in range(i + 1, l):
            if prices[i] < prices[k]:
                profit = violence(prices, k + 1) + prices[k] - prices[i]
                if profit > max_profit:
                    max_profit = profit
        if max_profit > final_max:
            final_max = max_profit
    return final_max


# leetcode submit region end(Prohibit modification and deletion)
a = [1,2,3,4,5]
print(Solution().maxProfit(a))
