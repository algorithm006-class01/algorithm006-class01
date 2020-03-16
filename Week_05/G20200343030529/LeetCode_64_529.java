class Solution {
    public int minPathSum(int[][] grid) {
       int[][] dp = new int[grid.length + 1][grid[0].length + 1];
       for (int k = 0; k < dp.length; k++) dp[k][dp[k].length - 1] = Integer.MAX_VALUE;
       for (int m = 0; m < dp[0].length; m++) dp[dp.length - 1][m] = Integer.MAX_VALUE;
       dp[grid.length][grid[0].length - 1] = 0;
       dp[grid.length - 1][grid[0].length] = 0;


       for (int i = dp.length - 2; i >= 0; i--) {
           for (int j = dp[i].length - 2; j >= 0; j--) {
               dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
           }
       }
       return dp[0][0];
    }
}