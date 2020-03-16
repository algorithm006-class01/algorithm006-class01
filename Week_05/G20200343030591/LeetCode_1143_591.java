class Solution {
    /**
     * 最长公共子序列
     * 动态规划
     * 注意：如果 s1 为 ABCDE s2 为 EC  那么EC中的C 不属于公共子序列
     * 顺序必须 字符串的顺序也必须一样 才行
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=1; i < m + 1; i++) {
            for (int j=1; j < n + 1; j++) {
                // 如果两个字符的最后一位相等，则计算他们前面的字符的长度 同时加上 相同那串字符的长度
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    // 否则如果 不相等的话 那个就 从 字符串1减一位 与 字符串2减一位中选择一个最大值
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}