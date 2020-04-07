package com.leetcode.week08;/*
 *
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */


import java.util.Arrays;

class Solution188_509 {
  public static void main(String[] args) {
    long startTime=System.nanoTime(); //获取开始时间

    Solution188_509 sol = new Solution188_509();
    System.out.println(sol.maxProfit(6, new int[]{3,2,6,5,0,3}));

    long endTime=System.nanoTime(); //获取结束时间
    System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
  }

  public int maxProfit(int k, int[] prices) {
    if (prices.length == 0) return 0;
    int n = prices.length;
    if (k > n/2) return maxProfit(prices);
    int[][][] dp = new int[n][k + 1][2];

    for (int i = 0; i < n; i++) {
      for (int j = k; j > 0; j--) {
        if (i - 1 == -1) {
          dp[i][j][0] = 0;
          dp[i][j][1] = -prices[i];
          continue;
        }
        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j-1][0] - prices[i]);
      }
    }
    System.out.println(Arrays.deepToString(dp));
    return dp[n-1][k][0];
  }

  public int maxProfit(int[] prices) {
    int total = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i] < prices[i+1]) {
        total += prices[i+1] - prices[i];
      }
    }
    return total;
  }
}