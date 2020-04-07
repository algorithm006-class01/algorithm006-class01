// https://leetcode-cn.com/problems/regular-expression-matching/

const isMatch = function (s, p) {
    let n = s.length;
    let m = p.length;
    let dp = Array.from(new Array(n + 1), () => new Array(m + 1).fill(false));
    dp[0][0] = true;
    for (let i = 0; i <= m; i++) {
        if (p[i] == '*' && dp[0][i - 1]) {
            dp[0][i + 1] = true;
        }
    }
    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= m; j++) {
            if (p[j - 1] == s[i - 1] || p[j - 1] == '.') {
                dp[i][j] = dp[i - 1][j - 1]
            } else if (p[j - 1] == '*') {
                if (p[j - 2] != s[i - 1]) {
                    dp[i][j] = dp[i][j - 2];
                }
                if (p[j - 2] == s[i - 1] || p[j - 2] == '.') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                }
            }
        }
    }
    return dp[n][m];
};