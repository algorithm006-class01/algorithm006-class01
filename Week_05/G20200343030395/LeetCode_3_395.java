package Week_05.G20200343030395;

public class LeetCode_3_395 {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cows = rows > 0 ? matrix[0].length : 0;

        int[][] dp = new int[rows + 1][cows + 1];

        int maxsqlen = 0;
        for (int i=1; i<=rows; i++) {
            for (int j=1; j<=cows; j++) {
                if(matrix[i-1][j-1] == '1') {
                    /**
                     * 里面的min: 取横着的和竖着的是不是0的，是0就不是正方形，都是x就可以变成x
                     * 外面的min：如果可以扩展成正方形，那就是min(x, dp[i-1][j-1])+1，至少0+1；
                     * 如果不能，就是min(0, dp[i-1][j-1]+1)， 就是0了
                     */
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }

        return maxsqlen * maxsqlen;
    }
}
