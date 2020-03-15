/*
    如果 matrix[i-1][j-1] == 0 ，DP[i, j] 也是 0，因為 square 不存在

    如果 matrix[i-1][j-1] == 1，那麼 DP[i, j] 就有以下幾種可能
    1）從DP [i-1,j] 這個形狀 加上一行
    2）從DP [i, j-1] 這個形狀 加上一列
    3）從DP [i-1, j-1] 這個正方形加上一行和一列

    子問題
    dp array: dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
    dp 方程


    time complexity: O(m*n), space complexity: O(m*n), m is matrix's width, n is matrix's height

*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;

        int dp[][] = new int[m+1][n+1];
        int maxLen = 0;

        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen*maxLen;
    }
}