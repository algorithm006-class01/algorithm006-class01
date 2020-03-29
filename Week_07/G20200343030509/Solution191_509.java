package com.leetcode.week07;/*
/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

class Solution191_509 {

  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int sum = 0;
    while (n != 0) {
      sum++;
      n = n & (n - 1);
    }
    return sum;
  }

  public static void main(String[] args) {
    long startTime=System.nanoTime(); //获取开始时间

    Solution191_509 sol = new Solution191_509();
    System.out.println(sol.hammingWeight(4));

    long endTime=System.nanoTime(); //获取结束时间
    System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
  }
}