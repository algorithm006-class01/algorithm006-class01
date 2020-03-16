 //方法一：二维DP 时间复杂度O(mn) 空间复杂度O(mn)
 // a.子问题 f[i,j] = grid[i,j] + min(f[i - 1,j],f[i,j - 1])
 // b.定义状态数组 f[i,j]
 // c.DP方程：
 //  dp[i,j] = grid[i,j] + min(dp[i - 1,j],dp[i,j-1])

  //方法二：一维DP 时间复杂度O(mn) 空间复杂度O(n)　　
 // a.子问题 f[j] = grid[j] + min(f[j],f[j - 1])
 // b.定义状态数组 f[j]
 // c.DP方程：
 //  dp[j] = grid[i,j] + min(dp[j],dp[j-1])
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || (grid.length == 1 && grid[0].length == 0)) {
            return 0;
        }
        
        int m = grid.length;//行数
        int n = grid[0].length;//列数

        //二维DP
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++){
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];

    }
}