/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int rl = word1.length(), cl = word2.length();
        int[][] dp = new int[rl + 1][cl + 1];
        for (int r = 0; r <= rl; r ++) {
            dp[r][0] = r;   
        }
        for (int c = 0; c <= cl; c ++) {
            dp[0][c] = c;
        }
        for (int r = 1; r <= rl; r ++) {
            for (int c = 1; c <= cl; c ++) {
                if (word1.charAt(r - 1) == word2.charAt(c - 1)) 
                    dp[r][c] = dp[r - 1][c - 1];
                else
                    dp[r][c] = Math.min(dp[r - 1][c - 1], Math.min(dp[r][c - 1], dp[r - 1][c])) + 1;
            }
        }
        return dp[rl][cl];
    }
}
// @lc code=end

