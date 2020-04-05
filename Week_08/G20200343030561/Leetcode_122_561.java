/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
// @solution dp
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i ++) {
            if (prices[i - 1] < prices[i])
                res += prices[i] - prices[i - 1] ;
        }
        return res;
    }
}
// @lc code=end

