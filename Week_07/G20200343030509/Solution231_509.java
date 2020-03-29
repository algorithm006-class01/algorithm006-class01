package com.leetcode.week07;/*
/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 */

class Solution231_509 {

  public boolean isPowerOfTwo(int n) {
    if (n == 0) return false;
    long x = (long) n;
    return (x & -x) == x;
  }

  public static void main(String[] args) {
    long startTime=System.nanoTime(); //获取开始时间

    Solution231_509 sol = new Solution231_509();
    System.out.println(sol.isPowerOfTwo(-2147483648));

    long endTime=System.nanoTime(); //获取结束时间
    System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
  }
}