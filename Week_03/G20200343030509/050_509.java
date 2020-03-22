/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

class Solution {
  // 暴力
  public double myPow(double x, int n) {
      long N = n;
      if (N < 0) {
          x = 1 / x;
          N = -N;
      }

      double result = 1;
      for (long i = 0; i < N; i++) {
          result *= x;
      }
      return result;
  }

  // 分治
  public double myPow1(double x, int n) {
    long N = n;
    if (N < 0) {
        x = 1 / x;
        N = -N;
    }

    return splitePow(x, N);
}

private double splitePow(double x, long n) {
    // terminator
    if (n == 0) {
        return 1;
    }

    // drill down
    double result = splitePow(x, n/2);

    // merge
    if (n%2 == 1) {
        result = result * result * x;
    }
    else {
        result *= result;
    }

    return result;
}
}