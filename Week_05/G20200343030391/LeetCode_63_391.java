package G20200343030391;

public class LeetCode_63_391 {

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[30][30];
        obstacleGrid[1][1] = 1;
        int i = new LeetCode_63_391().uniquePathsWithObstacles_2(obstacleGrid);
        System.out.println(i);
    }

    /**
     * 自底向上
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles_1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //考虑特殊情况
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        if (obstacleGrid[0][0] == 0 && m == 1 && n == 1) return 1;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
    /**
     * 记忆化搜索自顶向下
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles_2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        Integer[][] memo = new Integer[m][n];
        return memoSearch(obstacleGrid, 0, 0,memo);
    }


    private int memoSearch(int[][] obstacleGrid, int m, int n, Integer[][] memo) {
        if (m == obstacleGrid.length - 1 && n == obstacleGrid[0].length - 1 && obstacleGrid[m][n] != 1) {
            return memo[m][n] = 1;
        }
        if (m > obstacleGrid.length - 1 || n > obstacleGrid[0].length - 1 || obstacleGrid[m][n] == 1) {
            return 0;
        }
        if (memo[m][n] != null) {
            return memo[m][n];
        }
        return memo[m][n] = memoSearch(obstacleGrid, m + 1, n, memo) + memoSearch(obstacleGrid, m, n + 1, memo);
    }

}
