/**
 * @param {number[][]} grid
 * @return {number}
 */
// 二维DP方程： dp[i,j] = g[i,j] + min(dp[i+1, j], dp[i, j+1])
var minPathSum = function (grid) {
    const m = grid.length - 1
    const n = grid[0].length - 1
    const dp = grid
    for (let i = m; i >= 0; i--) {
        for (let j = n; j >= 0; j--) {
            if (i === m && j === n) {
                dp[i][j] = grid[i][j]
            } else if (i !== m && j === n) {
                dp[i][j] = grid[i][j] + dp[i + 1][j]
            } else if (i === m && j !== n) {
                dp[i][j] = grid[i][j] + dp[i][j + 1]
            } else {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j]
            }
        }
    }
    return dp[0][0]
};