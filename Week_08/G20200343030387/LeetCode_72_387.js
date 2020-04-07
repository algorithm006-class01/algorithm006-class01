/**
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
// 参考题解：编辑距离面试题详解
// 二维dp table，自底向上(i,j从0逐渐增大)
// 单词最后一位相同，执行替换
// 不同则用插入、删除、替换中步骤最小的
// dp table： 左上角为原点，向下为i轴正方向，向右为j轴正方向，(0,0)格子为空字符串所用
// word1[i] === word2[j] dp[i][j] = dp[i-1][j-1]
// word1[i] !== word2[j] dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
// dp[i-1][j-1] + 1 表示替换
// dp[i-1][j] + 1 表示删除
// dp[i][j-1] + 1 表示插入
var minDistance = function (word1, word2) {
    const m = word1.length
    const n = word2.length
    const dp = new Array(m + 1).fill().map(t => new Array(n + 1).fill())
    // 初始化第一行、列
    for (let i = 0; i <= m; i++) {
        dp[i][0] = i
    }
    for (let j = 0; j <= n; j++) {
        dp[0][j] = j
    }
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            if (word1[i - 1] === word2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
            }
        }
    }
    return dp[m][n]
};