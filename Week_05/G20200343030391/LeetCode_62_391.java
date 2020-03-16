package G20200343030391;

import java.util.Arrays;

public class LeetCode_62_391 {

    public static void main(String[] args) {
        int m = 4;
        int n = 4;
        int i = new LeetCode_62_391().uniquePaths_2(m, n);
        System.out.println(i);

    }

    /**
     * 二维数组
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    /**
     * 一维数组
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths_2(int m, int n) {
        int[] line = new int[n];
        Arrays.fill(line, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                line[j] += line[j - 1];
            }
        }
        return line[n - 1];
    }

}
