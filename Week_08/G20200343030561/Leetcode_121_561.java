/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @date Apr 1 2020
// @solution dp 1 最大连续子数组和
// class Solution {
//     public int maxProfit(int[] prices) {
//         int len = prices.length;
//         if (len <= 1) return 0;
//         int[] diff = new int[len - 1];
//         for (int i = 0; i < len - 1; i ++) 
//             diff[i] = prices[i + 1] - prices[i];
//         int[] dp = new int[len - 1];
//         int profit = dp[0] = Math.max(0, diff[0]);
//         System.out.println(dp[0]);
//         System.out.println(profit);
//         for (int i = 1; i < len - 1; i ++) {
//             dp[i] = Math.max(0, dp [i - 1] + diff[i]);
//             profit = Math.max(profit, dp[i]);
//         }
//         return profit;
//     }
// }

// @lc code=start
// @date Apr 1 2020
// @solution dp 2 remove dp array and diff array from dp 1
class Solution {
    public int maxProfit(int[] prices) {
        int yesterday = 0; int today = 0;
        for (int i = 0; i < prices.length - 1; i ++) {
            yesterday = Math.max(0, yesterday + prices[i + 1] - prices[i]);
            today = Math.max(today, yesterday);
        }
        return today;
    }
}
// @lc code=end

