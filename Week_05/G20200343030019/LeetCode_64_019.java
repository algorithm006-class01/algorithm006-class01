class Solution {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length + 1];
        dp[grid[0].length] = Integer.MAX_VALUE;
        for (int j = dp.length - 2, i = grid.length - 1; j >= 0; j --) {
            if (i == grid.length - 1) {
                if (j == dp.length - 2) {
                    dp[j] = grid[i][j];
                    continue;
                }
                dp[j] = grid[i][j] + dp[j + 1];
                continue;
            }
        }
        for (int i = grid.length - 2; i >= 0; i --) {
            for (int j = dp.length - 2; j >= 0; j --) {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}