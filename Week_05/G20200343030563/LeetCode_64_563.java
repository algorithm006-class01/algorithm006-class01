class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid == null || m == 0) return 0;

        int[][] dp = new int[m][n];

        dp[m-1][n-1] = grid[m-1][n-1];

        //最右边一列 j = n-1
        for (int i = m-2; i>= 0; i--)
            dp[i][n-1] = dp[i+1][n-1] + grid[i][n-1];

        //最下边一行 i =m-1
        for (int j = n-2; j>= 0; j--) {
            dp[m-1][j] = dp[m-1][j+1] + grid[m-1][j];
        }
        for (int i = m-2; i>= 0; i--)
            for (int j = n-2; j>= 0; j--) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + grid[i][j];
            }


        return dp[0][0];

    }
}