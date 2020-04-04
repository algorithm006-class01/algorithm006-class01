class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int k = 0; k < n; k++) {
            dp[0][k] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}