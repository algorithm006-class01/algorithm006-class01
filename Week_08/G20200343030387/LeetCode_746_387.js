/**
 * @param {number[]} cost
 * @return {number}
 */
// 动态规划
// 状态定义：dp[i] 走到第i个阶梯的最低花费体力值
// dp方程：dp[i] = min(dp[i-1], dp[i-2]) + dp[i]
// min(dp[n-1], dp[n-2])就是所求的解
// dp[n-1]表壳到达最顶，dp[n-1]表示到倒数第二层然后走两步跨过顶层（消耗为0）
var minCostClimbingStairs1 = function (cost) {
    const n = cost.length
    const dp = [cost[0], cost[1]]
    for (let i = 2; i < n; i++) {
        dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i]
    }
    return Math.min(dp[n - 1], dp[n - 2])
};

// 上题优化为O(1)空间复杂度
var minCostClimbingStairs = function (cost) {
    const n = cost.length
    let dp0 = cost[0]
    let dp1 = cost[1]
    for (let i = 2; i < n; i++) {
        const temp = dp1
        dp1 = Math.min(dp0, dp1) + cost[i]
        dp0 = temp
    }
    return Math.min(dp0, dp1)
};