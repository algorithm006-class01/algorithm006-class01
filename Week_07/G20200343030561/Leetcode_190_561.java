/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */


// class Solution {
//     // you need treat n as an unsigned value
//     public int reverseBits(int n) {
//         int res = 0;
//         for (int i = 0; i < 32; i ++) {
//             res = (res << 1) + (n & 1);
//             n = n >> 1;
//         }
//         return res;
//     }
// }

// @lc code=start
// @date Mar 28 2020
class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 31; n !=0 ; n = n >>> 1, i --)
            res += (n & 1) << i;
        return res;
    }
}
// @lc code=end

