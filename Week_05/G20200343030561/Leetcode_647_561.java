/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */


// class Solution {
//     public int countSubstrings(String s) {
//         int l = s.length();
//         boolean[][] dp = new boolean[l][l];
//         int res = 0;
//         for (int i = l - 1; i >= 0; i --) {
//             for (int j = i; j < l; j ++) {
//                 if ((j - i <= 2 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)) {
//                     dp[i][j] = true;
//                     res ++;
//                 }
//             }
//         }
//         return res;
//     }
// }

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int l = s.length();
        boolean[] dp = new boolean[l];
        int res = 0;
        for (int i = 0; i < l; i ++) {
            dp[i] = true; // 对角线
            res ++;
            for (int j = 0; j < i; j ++) {
                // dp[j+1] 为右上角
                if (s.charAt(i) == s.charAt(j) && dp[j+1]) {
                    dp[j] = true;
                    res ++;
                } else
                    dp[j] = false;
            }
        }
        return res;
    }
}
// @lc code=end

