package com.leetcode.week07;/*
/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

import java.util.Arrays;

class Solution338_509 {

  public int[] countBits(int num) {
    int[] res = new int[num + 1];
    res[0] = 0;
    for (int i = 0; i <= num; i++) {
      // 奇数的话比前一个数的1的数量+1，偶数的话跟前一个数的1的数量相同
      res[i] = (i & 1) == 1 ? res[i-1] + 1 : res[i>>1];
    }
    return res;
  }

  public static void main(String[] args) {
    long startTime=System.nanoTime(); //获取开始时间

    Solution338_509 sol = new Solution338_509();
    System.out.println(Arrays.toString(sol.countBits(4)));

    long endTime=System.nanoTime(); //获取结束时间
    System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
  }
}