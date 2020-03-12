/*
 * @lc app=leetcode.cn id=72 lang=cpp
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
public:
    int minDistance(string word1, string word2) {
        int n=word1.size(),m=word2.size();
        vector<vector<int>> dp(n+1,vector<int>(m+1));
        for(int i=0;i<=n;i++)
            dp[i][0]=i;
        for(int j=0;j<=m;j++)
            dp[0][j]=j;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=min(dp[i][j-1],dp[i-1][j])+1;
                dp[i][j]=min(dp[i][j],dp[i-1][j-1]+(word1[i-1]==word2[j-1]?0:1));
            }
        }
        return dp[n][m];
    }
};
// @lc code=end

