/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0;
        
        int in_index = 0;
        int out_index = 0;

        while (out_index < prices.length){
            if (out_index == prices.length-1){
                profit += prices[out_index] - prices[in_index];
                break;
            }

            out_index++;
            if (prices[out_index] <= prices[out_index-1]){
                profit += prices[out_index-1] - prices[in_index];
                in_index = out_index;
            }
        }

        return profit;
    }
}
// @lc code=end

