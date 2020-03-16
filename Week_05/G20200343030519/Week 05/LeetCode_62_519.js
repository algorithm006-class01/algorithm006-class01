// https://leetcode-cn.com/problems/unique-paths/

const uniquePaths = (m, n) => {
    let dp = Array.from(Array(n), () => Array(m).fill(1));

    for (let i = 1; i < n; i++) {
        for (let j = 1; j < m; j++) {
            dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
        }
    }
    
    return dp[n - 1][m - 1];
};