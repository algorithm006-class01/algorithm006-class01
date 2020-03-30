//题目链接：https://leetcode-cn.com/problems/number-of-1-bits/
public class Solution {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int sum = 0;
    while (n != 0) {
        sum++;
        n &= (n - 1);
    }
    return sum;
  }
}