/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */


// @date Apr 1 2020
// @solution dp 1
// class Solution {
//     public int maxProfit(int[] prices, int fee) {
//         int len = prices.length;
//         if (len <= 1) return 0;
//         int[] buy = new int[len], sell = new int[len];
//         buy[0] -= prices[0] + fee;
//         for (int i = 1; i < len; i ++) {
//             buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i] - fee);
//             sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
//         }
//         return sell[len - 1];
//     }
// }

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len <= 1) return 0;
        int sell = 0, buy = -prices[0] - fee;
        for (int price : prices) {
            buy = Math.max(buy, sell - price - fee);
            sell = Math.max(sell, buy + price);
        }
        return sell;
    }
}
// @lc code=end

