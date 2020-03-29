/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    // >>> 为无符号位移，高位补 0；>> 为有符号位移，正数高位补 0，负数高位补 1；
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            if ((n & 1) == 1) count++;
            n >>>= 1;
        }
        return count;
    }
}
// @lc code=end

