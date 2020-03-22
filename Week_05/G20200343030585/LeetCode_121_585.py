#
# @lc app=leetcode.cn id=121 lang=python
#
# [121] 买卖股票的最佳时机
#
# 解题思路
# 1.DP
#   1.subproblem 最大利润只会出现在最大利差之间，所以要找最大利差 
#       1.就是要找两个点，一个点是高点前的最低点，一个点是下一个低点前的最高点
#       2.比较每次这样的利差，看那个最大
#   2.dp数组 一个记录最小值，一个记录最大值
#   3.dp方程 f(i) = f(max) - f(min)
# @lc code=start
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        
        n = len(prices)
        if n == 0: return 0
        
        prev, cur, total = prices[0], 0, 0 
        
        for i in range(1, n):
            cur = prices[i]
            if prev > cur:
                prev = cur
            else:
                total = max(total, cur - prev)
        return total           
        
        
# @lc code=end

