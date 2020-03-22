//DP方程：dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1;
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || (matrix.length == 1 && matrix[0].length == 0)) {
            return 0;
        }

        int row = matrix.length; // 行数
        int col = matrix[0].length; // 列数

        int[][] dp = new int[row + 1][col + 1];
        int max = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j<= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}