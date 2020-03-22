class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = grid;
        // 初始化第一行
        for(int i=1;i<dp[0].length;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        //初始化第一列
        for(int i=1;i<dp.length;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}

/**
    子问题：
        
    状态转移方程：
        边界：
        dp[0][i] = dp[0][i-1] + grid[i][j]
        dp[i][0] = dp[i-1][0] + grid[i][j]
        非边界：
        dp[i][j] = max(dp[i-1][j],dp[i][j-1]) + grid[i][j]
    dp数组：
**/