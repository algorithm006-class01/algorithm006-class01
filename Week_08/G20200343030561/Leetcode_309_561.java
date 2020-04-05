/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @date Apr 1 2020
// @solution dp 1
// class Solution {
//     public int maxProfit(int[] prices) {
//         int len = prices.length;
//         if (len <= 1) return 0;
//         int[] sell = new int[len], buy = new int[len], cool = new int[len];
//         buy[0] = -prices[0];
//         for (int i = 1; i < len; i ++) {
//             buy[i] = Math.max(buy[i - 1], cool[i - 1] - prices[i]);
//             sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
//             cool[i] = sell[i - 1];
//         }
//         return Math.max(sell[len - 1], cool[len - 1]);
//     }
// }

// @lc code=start
// @solution dp 2 压缩数组
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        int sell = 0, buy = -prices[0], cool = 0;
        for (int price: prices) {
            int temp = sell;
            buy = Math.max(buy, cool - price);
            sell = Math.max(sell, buy + price);
            cool = temp;
        }
        return sell;
    }
}
// @lc code=end

