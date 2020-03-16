class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n+1][m+1];
        // 初始化第一行
        for (int j = 1; j <= m; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 初始化第一列
        for (int i = 1; i <= n; i++) dp[i][0] = dp[i - 1][0] + 1;

        // dp计算
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
            }
        }
        return dp[n][m];
    }
}


/**
    子问题：
    
    状态转移方程：
        字符相等：word1(n) == word2[m]:
            dp[n][m] = dp[n-1][m-1];
        字符不等：
            dp[n][m] = min(dp[n-1][m-1], dp[n-1][m], dp[n][m-1]) + 1
    dp数组：
        n = word1.length
        m = word2.length
        dp[n][m]
**/