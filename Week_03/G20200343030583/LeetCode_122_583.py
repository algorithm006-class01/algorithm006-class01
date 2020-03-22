#
# @lc app=leetcode id=122 lang=python
#
# [122] Best Time to Buy and Sell Stock II
#

# @lc code=start
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices and len(prices) == 1:
            return 0
        profit = 0
        for i in range(len(prices) - 1):
            if prices[i] < prices[i+1]:
                profit += prices[i+1] - prices[i]

        return profit 
        # 1 line solution
        # return sum([y - x for x, y in zip(prices[:-1], prices[1:]) if x < y])
# @lc code=end

