/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        // int ans = 0;
        // int i = 32;
        // while (i != 0){
        //     i--;
        //     ans <<= 1;
        //     ans += n & 1;
        //     n >>>= 1;
        // }
        // return ans;


        // java源码 Integer.reverse
        n = (n & 0x55555555) << 1 | (n >>> 1) & 0x55555555;
        n = (n & 0x33333333) << 2 | (n >>> 2) & 0x33333333;
        n = (n & 0x0f0f0f0f) << 4 | (n >>> 4) & 0x0f0f0f0f;
        n = (n << 24) | ((n & 0xff00) << 8) |
            ((n >>> 8) & 0xff00) | (n >>> 24);
        return n;
    }
}
// @lc code=end

