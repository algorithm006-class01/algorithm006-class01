package G20200343030391;

import java.util.Arrays;

public class LeetCode_1143_391 {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int i = new LeetCode_1143_391().longestCommonSubsequence(text1, text2);
        System.out.println(i);

    }

    /**
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] textChar1 = text1.toCharArray();
        char[] textChar2 = text2.toCharArray();
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (textChar1[i - 1] == textChar2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[length1][length2];
    }
}
