package com.leetcode.week08;/*
/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

import java.util.Arrays;

class Solution198_509 {

  public int rob(int[] nums) {
    if (nums == null || nums.length < 1) return 0;

    int[] dp = new int[nums.length + 1];
    dp[0] = 0;
    dp[1] = nums[0];

    for (int i = 2; i <= nums.length; i++) {
      dp[i] = Math.max(nums[i-1] + dp[i-2], dp[i-1]);
    }
    System.out.println(Arrays.toString(dp));
    return dp[nums.length];
  }

  public static void main(String[] args) {
    long startTime=System.nanoTime(); //获取开始时间

    Solution198_509 sol = new Solution198_509();
    System.out.println(sol.rob(new int[]{1,2,3,1}));

    long endTime=System.nanoTime(); //获取结束时间
    System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
  }
}