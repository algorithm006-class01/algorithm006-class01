/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 *
 * https://leetcode-cn.com/problems/reverse-bits/description/
 *
 */

// @lc code=start
class Solution {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int result = 0;
    for (int i = 0; i <= 32; i++) {
      int tmp = n >> i;
      tmp = tmp & 1;
      tmp = tmp << (31 - i);
      result |= tmp;
    }
    return result;
  }
}
// @lc code=end
