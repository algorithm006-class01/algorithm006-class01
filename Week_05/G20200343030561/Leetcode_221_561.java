/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int rl = matrix.length, cl = matrix[0].length;
        int[][] dp = new int[rl + 1][cl + 1];
        
        int res = 0;
        for (int r = 1; r <= rl; r ++) {
            for (int c = 1; c <= cl; c ++) {
                if (matrix[r - 1][c - 1] == '1') {
                    dp[r][c] = Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1])) + 1;
                    res = Math.max(res, dp[r][c]);
                }
            }
        }
        return res * res;
    }
}
// @lc code=end

