/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 * 
 */

// @lc code=start
class Solution {
  // 暴力 超时
  public int minPathSum(int[][] grid) {
    return calculate(grid, 0, 0);
  }

  public int calculate(int[][] grid, int i, int j) {
    if (i == grid.length || j == grid[0].length)
      return Integer.MAX_VALUE;
    if (i == grid.length - 1 && j == grid[0].length - 1)
      return grid[i][j];
    return grid[i][j] + Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1));
  }

  // 动态规划
  public int minPathSum2(int[][] grid) {
    int[][] dp = new int[grid.length][grid[0].length];
    for (int i = grid.length - 1; i >= 0; i--) {
      for (int j = grid[0].length - 1; j >= 0; j--) {
        if (i == grid.length - 1 && j != grid[0].length - 1)
          dp[i][j] = grid[i][j] + dp[i][j + 1];
        else if (j == grid[0].length - 1 && i != grid.length - 1)
          dp[i][j] = grid[i][j] + dp[i + 1][j];
        else if (j != grid[0].length - 1 && i != grid.length - 1)
          dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
        else
          dp[i][j] = grid[i][j];
      }
    }
    return dp[0][0];
  }

  // 动态规划 空间复杂度 O(1)
  public int minPathSum3(int[][] grid) {
    for (int i = grid.length - 1; i >= 0; i--) {
      for (int j = grid[0].length - 1; j >= 0; j--) {
        if (i == grid.length - 1 && j != grid[0].length - 1)
          grid[i][j] = grid[i][j] + grid[i][j + 1];
        else if (j == grid[0].length - 1 && i != grid.length - 1)
          grid[i][j] = grid[i][j] + grid[i + 1][j];
        else if (j != grid[0].length - 1 && i != grid.length - 1)
          grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
      }
    }
    return grid[0][0];
  }
}
// @lc code=end
