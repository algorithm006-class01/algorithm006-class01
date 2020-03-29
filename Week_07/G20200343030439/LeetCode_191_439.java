/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 *
 * https://leetcode-cn.com/problems/number-of-1-bits/description/
 * 
 */

// @lc code=start
class Solution {
  // you need to treat n as an unsigned value
  public static int hammingWeight(int n) {
    int sum = 0;
    while (n != 0) {
      sum++;
      n &= (n - 1);
    }
    return sum;
  }
}
// @lc code=end
