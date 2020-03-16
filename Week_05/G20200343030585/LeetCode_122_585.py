#
# @lc app=leetcode.cn id=122 lang=python
#
# [122] 买卖股票的最佳时机 II
#
# 解题思路
# 1.dp
#   1.subproblem 多次买卖的最大值，等于每次获利最大的和值
#   2.dp数组  不需要，只需要知道前面的最小值和最大值就可以
#   3.dp方程  f(n) = f(n-1) + f(n-2) 
# 2.贪心
#   1.只要每天有收益，就是总结果就是最好的，不用找最大的差值

# @lc code=start
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        
        n = len(prices)
        if n <= 1:
            return 0
        
        cur, prev,total = 0, prices[0], 0
        for i in range(1, n):
            cur = prices[i]
            total += max(0, cur - prev)
            prev = cur
        
        return total
        

# class Solution(object):
#     def maxProfit(self, prices):
#         """
#         :type prices: List[int]
#         :rtype: int
#         """
#         if len(prices) == 0:
#             return 0
#         length = len(prices)
        
#         total = 0
#         for i in range(length):
#             if i - 1 >= 0 and prices[i] - prices[i-1] > 0:
#                 total += prices[i] - prices[i-1]
            
#         return total

# @lc code=end

