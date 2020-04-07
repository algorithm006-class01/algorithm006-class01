package com.leetcode.week08;/*
/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */


import java.util.Arrays;

class Solution123_509 {
  public static void main(String[] args) {
    long startTime=System.nanoTime(); //获取开始时间

    Solution123_509 sol = new Solution123_509();
    System.out.println(sol.maxProfit(new int[]{3,3,5,0,0,3,1,4}));

    long endTime=System.nanoTime(); //获取结束时间
    System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
  }

  public int maxProfit(int[] prices) {
    if (prices.length == 0) return 0;
    int n = prices.length;
    int max_k = 2;
    int[][][] dp = new int[n][max_k + 1][2];

    for (int i = 0; i < n; i++) {
      for (int k = 2; k > 0; k--) {
        if (i - 1 == -1) {
          dp[i][k][0] = 0;
          dp[i][k][1] = -prices[i];
          continue;
        }
        dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
        dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k-1][0] - prices[i]);
      }
    }
    System.out.println(Arrays.deepToString(dp));
    return dp[n-1][max_k][0];
  }
}