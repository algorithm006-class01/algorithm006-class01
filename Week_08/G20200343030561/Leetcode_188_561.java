/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        if(k >= len / 2) { // just for a very large test case
            int profit = 0;
            for(int i = 1; i < len; i ++){
                if(prices[i] > prices[i - 1]){
                    profit += prices[i] - prices[i-1];
                }
            }
            return profit;
        }

        int[] buy = new int[k + 1], sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int i = 1; i <= k; i ++) {
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k];
    }
}
// @lc code=end

