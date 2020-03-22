public class Solution {
    public int MinDistance(string word1, string word2) {
        int len1 = word1.Length;
        int len2 = word2.Length;
        int[,] dp = new int[len1 + 1, len2 + 1];
        dp[0, 0] = 0;

        for (int i = 1; i <= len1; i++) {
            dp[i, 0] = i;
        }

        for (int i = 1; i <= len2; i++) {
            dp[0, i] = i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i, j] = dp[i - 1, j - 1];
                }
                else {
                    dp[i, j] = 1 + Math.Min(Math.Min(dp[i - 1, j], dp[i, j - 1]), dp[i - 1, j - 1]);
                }
            }
        }

        return dp[len1, len2];
    }
}