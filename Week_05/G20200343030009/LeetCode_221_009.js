/*
  221. 最大正方形
  难度： 中等
  在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

  示例:
  输入: 
  1 0 1 0 0
  1 0 1 1 1
  1 1 1 1 1
  1 0 0 1 0
  输出: 4
*/
/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function(matrix) {
  // 1. 重复性（分治） problem[i][j] = 
  // 2. 定义状态数组
  // 3. DP方程 dp(i, j) = min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1)) + 1
  let rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0
  // 初始化状态数组（二维）,每个元素为0, 用于之后的Math.min计算，否则二维数组默认元素为undefined，得到结果为NaN
  let dp = []
  for (let i = 0; i <= rows; i++) {
      dp[i] = []
  }
  for (let i = 0; i <= rows; i++) {
      for (let j = 0; j <= cols; j++) {
          dp[i][j] = 0
      }
  }

  let maxslen = 0
  for (let i = 1; i <= rows; i++) {
      for (let j = 1; j <= cols; j++) {
          if (matrix[i-1][j-1] === '1') {
              dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1
              maxslen = Math.max(maxslen, dp[i][j])
          }
      }
  }
  return maxslen * maxslen
};