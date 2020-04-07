/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        int f = 0, r = s.length - 1;
        while (f < r) {
            char temp = s[f];
            s[f ++] = s[r];
            s[r --] = temp;
        }
    }
}
// @lc code=end

