/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (64.77%)
 * Likes:    403
 * Dislikes: 0
 * Total Accepted:    66.3K
 * Total Submissions: 102.3K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 */

// @lc code=start
class Solution {
    // 动态规划：
    // f(i, j) = cell[i][j] + f(i - 1, j - 1)
    // 空间复杂度：m * n
    public int minPathSum1(int[][] grid) {
        if (null == grid || 0 == grid.length)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        // 处理边界值
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                dp[r][c] = grid[r][c] + Math.min(dp[r - 1][c], dp[r][c - 1]);
            }
        }

        return dp[rows - 1][cols - 1];
    }

    // 动态规划：
    // f(i, j) = cell[i][j] + f(i - 1, j - 1)
    // 空间复杂度：O(n)
    public int minPathSum2(int[][] grid) {
        if (null == grid || 0 == grid.length) return 0;
        int rows = grid.length, cols = grid[0].length;
        int[] dp = new int[cols];

        // 处理边界值
        dp[0] = grid[0][0];
        for (int c = 1; c < cols; c++)
            dp[c] = dp[c - 1] + grid[0][c];

        for (int r = 1; r < rows; r++) {
            dp[0] = grid[r][0] + dp[0];
            for (int c = 1; c < cols; c++) {
                dp[c] = grid[r][c] + Math.min(dp[c - 1], dp[c]);
            }
        }

        return dp[cols - 1];
     }

    // 动态规划：
    // f(i, j) = cell[i][j] + f(i - 1, j - 1)
    // 空间复杂度：O(1) 直接借用了原二维数组 
     public int minPathSum(int[][] grid) {
        if (null == grid || 0 == grid.length) return 0;
        int rows = grid.length, cols = grid[0].length;

        // 处理边界值
        for (int c = 1; c < cols; c++) 
            grid[0][c] += grid[0][c - 1];
        
        for (int r = 1; r < rows; r++) {
            grid[r][0] += grid[r - 1][0];
            for (int c = 1; c < cols; c++)
                grid[r][c] += Math.min(grid[r - 1][c], grid[r][c - 1]);
        }

        return grid[rows - 1][cols - 1];
     }
}
// @lc code=end

