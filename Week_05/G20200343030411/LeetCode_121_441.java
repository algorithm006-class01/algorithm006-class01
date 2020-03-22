/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int in_index = 0;
        int out_index = 0;

        for (int i = 1; i < prices.length; ++i){
            if (in_index == out_index && prices[i] < prices[in_index]){
                out_index = i;
                in_index = i;
            }
            if (prices[i] > prices[out_index]){
                out_index = i;
                max_profit = Math.max(max_profit, prices[out_index] - prices[in_index]);
            }
            if (prices[i] < prices[in_index]){
                out_index = i;
                in_index = i;
            }
        }

        return max_profit;
    }
}
// @lc code=end

