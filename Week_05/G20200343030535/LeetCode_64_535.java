package leetcode.Week05;

public class LeetCode_64_535 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n =  grid[0].length;
        int[][] dp = grid;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n ; j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0)  dp[i][j] = dp[i][j - 1] + dp[i][j];
                else if(j == 0)  dp[i][j] = dp[i - 1][j] + dp[i][j];
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + dp[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

}
