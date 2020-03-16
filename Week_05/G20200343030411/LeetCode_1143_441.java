/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
class Solution {
    // 自己的解法，效率低
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] states = new int[text1.length()][text2.length()];

        int flag = 0;
        for (int i = 0; i < text1.length(); ++i){
            if (flag == 1) states[i][0] = 1;
            else if (text1.charAt(i) == text2.charAt(0)){
                states[i][0] = 1;
                flag = 1;
            }
        }

        flag = 0;
        for (int i = 0; i < text2.length(); ++i){
            if (flag == 1) states[0][i] = 1;
            else if (text2.charAt(i) == text1.charAt(0)){
                states[0][i] = 1;
                flag = 1;
            }
        }

        for (int i = 1; i < text1.length(); ++i){
            for (int j = 1; j < text2.length(); ++j){
                if (text1.charAt(i) == text2.charAt(j)){
                    states[i][j] = states[i-1][j-1] + 1;
                }else {
                    states[i][j] = Math.max(states[i][j-1], states[i-1][j]);
                }
            }
        }

        return states[text1.length()-1][text2.length()-1];
    }
}
// @lc code=end

