package datast.dp;

public class LeetCode_72_611 {

    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) dp[i][0] = dp[i - 1][0] + 1;
            for (int i = 1; i <= n; i++) dp[0][i] = dp[0][i - 1] + 1;

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        int temp = Math.min(dp[i - 1][j], dp[i][j - 1]);
                        dp[i][j] = Math.min(temp, dp[i - 1][j - 1]) + 1;
                    }
                }
            }
            return dp[m][n];
        }
    }
}
