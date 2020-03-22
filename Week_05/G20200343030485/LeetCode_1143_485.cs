public class Solution {
    public int LongestCommonSubsequence(string text1, string text2) {
        int len1 = text1.Length;
        int len2 = text2.Length;

        int[,] dp = new int[len1 + 1, len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1[i - 1] == text2[j - 1]) {
                    dp[i, j] = dp[i - 1, j - 1] + 1;
                }
                else {
                    dp[i, j] = Math.Max(dp[i - 1, j], dp[i, j - 1]);
                }
            }
        }

        return dp[len1, len2];
    }
}