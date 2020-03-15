/**
 * @param {number[][]} grid
 * @return {number}
 */
// 递归
// 超时
var minPathSum1 = function (grid) {
    const m = grid.length
    const n = grid[0].length
    function reversion(i, j, grid) {
        if (i === m || j === n) return Infinity
        if (i === m - 1 && j === n - 1) return grid[i][j]
        return grid[i][j] + Math.min(reversion(i + 1, j, grid), reversion(i, j + 1, grid))
    }
    return reversion(0, 0, grid)
}

// 二维DP方程： dp[i,j] = g[i,j] + min(dp[i+1, j], dp[i, j+1])
var minPathSum2 = function (grid) {
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

// 一维DP方程： dp[j] = g[i,j] + min(dp[j], dp[j+1])
var minPathSum = function (grid) {
    const m = grid.length - 1
    const n = grid[0].length - 1
    const dp = []
    for (let i = m; i >= 0; i--) {
        for (let j = n; j >= 0; j--) {
            if (i === m && j === n) {
                dp[j] = grid[i][j]
            } else if (i === m && j !== n) {
                dp[j] = dp[j + 1] + grid[i][j]
            } else if (i !== m && j === n) {
                dp[j] += grid[i][j]
            } else {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1])
            }
        }
    }
    return dp[0]
}