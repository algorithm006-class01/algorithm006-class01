package com.leetcode.week08;/*
/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

class Solution070_509 {

  public int climbStairs(int n) {
    if (n < 2) return n;
    int[] dp = new int[n];
    dp[0] = 1;
    dp[1] = 2;
    for (int i = 2; i < n; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n-1];
  }

  public static void main(String[] args) {
    long startTime=System.nanoTime(); //获取开始时间

    Solution070_509 sol = new Solution070_509();
    System.out.println(sol.climbStairs(3));

    long endTime=System.nanoTime(); //获取结束时间
    System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
  }
}