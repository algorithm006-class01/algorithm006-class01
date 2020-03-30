package com.leetcode.week07;/*
/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

class Solution052_509 {

  private int size;
  private int count;
  public int totalNQueens(int n) {
    count = 0;
    size = (1 << n) - 1;
    System.out.println("size=" + Integer.toBinaryString(size));
    solve(0, 0, 0);
    return count;
  }

  private void solve(int row, int left, int right) {
    if (row == size) {
      count++;
      return;
    }
    int pos = size & (~(row | left | right));
    System.out.println("pos=" + Integer.toBinaryString(pos) + ", row=" + Integer.toBinaryString(row) + ", left=" + Integer.toBinaryString(left) + ", right=" + Integer.toBinaryString(right));
    while (pos != 0) {
      int p = pos & (-pos);
      System.out.println("p=" + Integer.toBinaryString(p) + ", pos=" + Integer.toBinaryString(pos));
      pos -= p;
      System.out.println("pos=" + Integer.toBinaryString(pos));
      solve(row + p, (left + p) << 1, (right + p) >> 1);
    }
  }

  public static void main(String[] args) {
    long startTime=System.nanoTime(); //获取开始时间

    Solution052_509 sol = new Solution052_509();
    System.out.println(sol.totalNQueens(4));

    long endTime=System.nanoTime(); //获取结束时间
    System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
  }
}