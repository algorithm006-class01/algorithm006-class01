// https://leetcode-cn.com/problems/distinct-subsequences/

const numDistinct = function (s, t) {
    let n = s.length;
    let m = t.length;
    let dp = Array.from(new Array(m + 1), () => new Array(n + 1).fill(0));
    for (let i = 0; i <= n; i++) {
        dp[0][i] = 1;
    }
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            if (t[i - 1] == s[j - 1]) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
            } else {
                dp[i][j] = dp[i][j - 1];
            }
        }
    }
    return dp[m][n];
};