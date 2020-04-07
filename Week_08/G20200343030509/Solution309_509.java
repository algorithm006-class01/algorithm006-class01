package com.leetcode.week08;/*
/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

class Solution309_509 {
  public static void main(String[] args) {
    long startTime=System.nanoTime(); //获取开始时间

    Solution309_509 sol = new Solution309_509();
    System.out.println(sol.maxProfit(new int[]{1,2,3,0,2}));

    long endTime=System.nanoTime(); //获取结束时间
    System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
  }

  public int maxProfit(int[] prices) {
      if (prices.length == 0) return 0;
      int n = prices.length;
      int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
      int dp_pre_0 = 0;
      for (int i = 0; i < n; i++) {
        int temp = dp_i_0;
        dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
        dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
        dp_pre_0 = temp;
      }
      return dp_i_0;
  }
}