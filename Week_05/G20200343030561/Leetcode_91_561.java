/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int l = s.length();
        int[][] dp = new int[l + 1][3];
        dp[1][1] = singleDigit(s, 1) ? 1 : 0;
        if (l == 1) return dp[1][1];
        dp[2][1] = singleDigit(s, 2) ? dp[1][1] : 0;
        dp[2][2] = doubleDigit(s, 2) ? 1 : 0;
        if (l == 2) return dp[2][1] + dp[2][2];
        for (int i = 3; i <= l; i ++) {
            dp[i][1] = singleDigit(s, i) ? dp[i - 1][1] + dp[i - 1][2] : 0;
            dp[i][2] = doubleDigit(s, i) ? dp[i - 2][1] + dp[i - 2][2] : 0;
        }
        return dp[l][1] + dp[l][2];
    }
    boolean singleDigit (String s, int i) {
        int n = Integer.parseInt(s.substring(i - 1, i));
        return n > 0;
    }
    boolean doubleDigit (String s, int i) {
        int n = Integer.parseInt(s.substring(i - 2, i));
        return n <= 26 && n >= 10;
    }
}
// @lc code=end

