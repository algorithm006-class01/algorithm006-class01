/**
 * @param {number[]} prices
 * @return {number}
 */
// 动态规划
// 状态 dp[i][k][s] 表示第i天交易了k次，当前是持有还是没持有股票(0没持有，1持有))，最大利润
// 这里的k为1
// dp方程：
// dp[i][1][0] = max(dp[i-1][1][1] + prices[i], dp[i-1][1][0])
// dp[i][1][1] = max(dp[i-1][0][0] - prices[i], dp[i-1][1][1]) = max(- prices[i], dp[i-1][1][1])
// dp[i-1][0][0]为base case，值为0，因为k为0表示不能交易，当前又没有股票，所以利润肯定是0
// 由于k在方程里一直是1，不影响结果，所以可以省略
// dp方程化简为：
// dp[i][0] = max(dp[i-1][1] + prices[i], dp[i-1][0])
// dp[i][1] = max(-prices[i], dp[i-1][1])
// 最大利润在dp[n-1][0]上，因为最后肯定是未持有才是最大的
var maxProfit1 = function (prices) {
    const n = prices.length
    if (n === 0) return 0
    const dp = new Array(n).fill(new Array(2).fill())
    dp[0][0] = 0
    dp[0][1] = -prices[0]
    for (let i = 1; i < n; i++) {
        dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0])
        dp[i][1] = Math.max(-prices[i], dp[i - 1][1])
    }
    return dp[n - 1][0]
};

// O(1)空间复杂度
var maxProfit = function (prices) {
    const n = prices.length
    if (n === 0) return 0
    let dp_i_0 = 0, dp_i_1 = -prices[0]
    for (let i = 1; i < n; i++) {
        dp_i_0 = Math.max(dp_i_1 + prices[i], dp_i_0)
        dp_i_1 = Math.max(-prices[i], dp_i_1)
    }
    return dp_i_0
}