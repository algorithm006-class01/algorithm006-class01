package com.leetcode.week08;/*
/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

import java.util.Arrays;

class Solution714_509 {
  public static void main(String[] args) {
    long startTime=System.nanoTime(); //获取开始时间

    Solution714_509 sol = new Solution714_509();
    System.out.println(sol.maxProfit(new int[]{1,3,2,8,4,9}, 2));

    long endTime=System.nanoTime(); //获取结束时间
    System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
  }

  public int maxProfit(int[] prices, int fee) {
      int n = prices.length;
      if (n == 0) return 0;
      int[][] dp = new int[n][2];
      for (int i = 0; i < n; i++) {
        if (i-1 == -1) {
          dp[i][0] = 0;
          dp[i][1] = -prices[i];
          continue;
        }
        dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
        dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
      }
      System.out.println(Arrays.deepToString(dp));
      return dp[n-1][0];
  }

}