class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        int temp = 0;
        for(int i = 0; i < grid.length; i++){
            dp[i][0] = grid[i][0] + temp;
            temp = dp[i][0];
        }

        temp = 0;
        for(int i = 0; i < grid[0].length; i++){
            dp[0][i] = grid[0][i] + temp;
            temp = dp[0][i];
        }

        for(int i = 1;i < grid.length;i++){
            for(int j = 1; j < grid[0].length; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}