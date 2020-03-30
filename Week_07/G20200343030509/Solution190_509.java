package com.leetcode.week07;/*
/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

class Solution190_509 {

  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
      int cur = n & 1;
      res += (cur << (31 - i));
      n = n >> 1;
    }
    return res;
  }

  public static void main(String[] args) {
    long startTime=System.nanoTime(); //获取开始时间

    Solution190_509 sol = new Solution190_509();
    int n = 6;
    System.out.println(Integer.toBinaryString(n));
    System.out.println(Integer.toBinaryString(sol.reverseBits(6)));

    long endTime=System.nanoTime(); //获取结束时间
    System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
  }
}