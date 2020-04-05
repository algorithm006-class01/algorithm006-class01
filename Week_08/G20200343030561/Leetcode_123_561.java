/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */
// @lc code=start
// @date Apr 1 2020
// @solution dp 1
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        int[][] buy = new int[len][3], sell = new int[len][3];
        
        for (int i = 0; i < len; i ++) 
            Arrays.fill(buy[i], Integer.MIN_VALUE);
        buy[0][1] = -prices[0];
        for (int i = 1; i < len; i ++) {
            for (int j = 1; j <= 2; j ++) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j - 1] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j] + prices[i]);
            }
        }
        return Math.max(0, Math.max(sell[len - 1][2], sell[len - 1][1]));
    }
}


// @date Apr 1 2020
// @solution dp 2 压缩数组
// class Solution {
//     public int maxProfit(int[] prices) {
//         if (prices.length <= 1) return 0;
//         int[] buy = new int[3], sell = new int[3];
//         Arrays.fill(buy, Integer.MIN_VALUE);
//         for (int price: prices) {
//             for (int i = 1; i <= 2; i ++) {
//                 buy[i] = Math.max(buy[i], sell[i - 1] - price);
//                 sell[i] = Math.max(sell[i], buy[i] + price);
//             }
//         }
//         return sell[2];
//     }
// }
// @lc code=end

