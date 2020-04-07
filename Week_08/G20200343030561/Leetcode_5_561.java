/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @date Apr 5 2020
// class Solution {
//     public String longestPalindrome(String s) {
//         if(s == null || s.length() == 0) return "";
//         int f = 0, r = 0; // front rear
//         for (int i = 0; i < s.length(); i ++) {
//             int len = Math.max(expand(s, i, i), expand(s, i, i + 1));
//             if (len > r - f) {
//                 f = i - (len - 1) / 2;
//                 r = i + len / 2;
//             }
//         }
//         return s.substring(f, r + 1);
//     }
//     int expand(String s, int l, int r) {
//         for (; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r); l -- , r ++);
//         return r - l - 1;
//     }
// }

// @date Apr 5 2020
// @solution dp 1
// class Solution {
//     public String longestPalindrome(String s) {
//         int len = s.length();
//         String res = "";
//         boolean[][] dp = new boolean[len][len];
//         for (int i = len - 1; i >= 0; i --) {
//             for (int j = i; j < len ; j ++) {
//                 dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
//                 if (dp[i][j] && j + 1 - i > res.length())
//                     res = s.substring(i, j + 1);
//             }
//         }
//         return res;
//     }
// }

// @date Apr 5 2020
// @solution dp 2
// class Solution {
//     public String longestPalindrome(String s) {
//         int len = s.length();
//         String res = "";
//         boolean[] dp = new boolean[len];
//         for (int i = len - 1; i >= 0; i --) {
//             for (int j = len - 1; j >= i; j --) {
//                 dp[j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[j -1]);
//                 if (dp[j] && j + 1 - i > res.length())
//                     res = s.substring(i, j + 1);
//             }
//         }
//         return res;
//     }
// }

// @lc code=start
// @date Apr 5 2020
// @solution Manacher's AQlgorithm dp 3
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) return "";
        String t = "^";
        for (int i = 0; i < len; i++)
            t += "#" + s.charAt(i);
        t += "#$";
        len = t.length();
        int[] dp = new int[len];
        int center = 0, border = 0; // border == center + dp[i]
        for (int r = 1; r < len - 1; r ++) {
            int l = center - (r - center);
            dp[r] = (border > r) ? Math.min(border - r, dp[l]) : 0;
            while (t.charAt(r + 1 + dp[r]) == t.charAt(r - 1 - dp[r]))
                dp[r] ++;
            if (r + dp[r] > border) {
                center = r;
                border = center + dp[r];
            }
        }
        int max = 0;
        center = 0;
        for (int i = 1; i < len - 1; i++) {
            if (dp[i] > max) {
                max = dp[i];
                center = i;
            }
        }
        int start = (center - max) / 2;
        return s.substring(start, start + max);
    }
}
// @lc code=end

