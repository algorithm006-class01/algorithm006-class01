/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int rl = grid.length, cl = grid[0].length;
        int[][] dp = new int[rl][cl];
        dp[0][0] = grid[0][0];
        for (int c = 1; c < cl; c ++) {
            dp[0][c] = dp[0][c - 1] + grid[0][c];
        }
        for (int r = 1; r < rl; r ++) {
            dp[r][0] = dp[r - 1][0] + grid[r][0];
        }
        for (int r = 1; r < rl; r ++) {
            for (int c = 1; c < cl; c ++) {
                dp[r][c] = Math.min(dp[r - 1][c], dp[r][c - 1]) + grid[r][c];
            }
        }
        return dp[rl - 1][cl - 1];
    }
}
// @lc code=end

