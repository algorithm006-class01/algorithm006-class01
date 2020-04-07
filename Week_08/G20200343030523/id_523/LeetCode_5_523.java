package dynamic;

/**
 * @description: https://leetcode-cn.com/problems/longest-palindromic-substring
 * @author: zhujiashuai
 * @date: 2020/4/5
 * @time: 9:56 下午
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null) {
            return "";
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        String res = "";
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        LongestPalindromicSubstring substring = new LongestPalindromicSubstring();
        System.out.println(substring.longestPalindrome(s));
    }

}
