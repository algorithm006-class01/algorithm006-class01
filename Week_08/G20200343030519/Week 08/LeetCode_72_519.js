// https://leetcode-cn.com/problems/edit-distance/

const minDistance = function (word1, word2) {
    let n = word1.length;
    let m = word2.length;
    let dp = [];
    for (let i = 0; i <= n; i++) {
        dp.push([])
        for (let j = 0; j <= m; j++) {
            if (i * j) {
                dp[i][j] = word1[i - 1] == word2[j - 1] ? dp[i - 1][j - 1] : (Math.min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1);
            } else {
                dp[i][j] = i + j;
            }
        }
    }
    return dp[n][m];
};