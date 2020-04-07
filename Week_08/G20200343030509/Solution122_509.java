package com.leetcode.week08;/*
/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

import java.util.Arrays;

class Solution122_509 {
  public static void main(String[] args) {
    long startTime=System.nanoTime(); //获取开始时间

    Solution122_509 sol = new Solution122_509();
    System.out.println(sol.maxProfit3(new int[]{7,1,5,3,6,4}));

    long endTime=System.nanoTime(); //获取结束时间
    System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
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

  public int maxProfit2(int[] prices) {
    if (prices.length == 0) return 0;
    int n = prices.length;
    int[][] dp = new int[n][2];
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
    }
    System.out.println(Arrays.deepToString(dp));
    return dp[n-1][0];
  }

  public int maxProfit3 (int[] prices) {
    int n = prices.length;
    int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int temp = dp_i_0;
      dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
      dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
      System.out.println(dp_i_0 + "," + dp_i_1);
    }
    return dp_i_0;
  }
}