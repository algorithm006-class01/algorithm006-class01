#
# @lc app=leetcode.cn id=123 lang=python
#
# [123] 买卖股票的最佳时机 III
#
# 解题思路
# 1.DP
#   1.subproblem 
#       1.只有一次买卖得到最大
#       2.两次分两半产出最大
#       3.f(n) = f(k) + f(n-k)
#   2.DP数组 dp[0][1] 0为小值，1为大值
#   3.DP方程 f(n) = f(k) + f(n-k)
#       1. f(k) = max(f(i))

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
        
        max_list = []
        cur, prev = 0, prices[0]
        for i in range(1, n):
            cur = prices[i]
            if cur > prev :
                max_list.append(cur - prev)
                prev = cur
            elif cur < prev:
                prev = cur
                
        max_list.sort(reverse=True)
        print(max_list)
        return max_list[0] + max_list[1]

        
# @lc code=end

