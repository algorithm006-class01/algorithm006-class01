/*
  64. 最小路径和
  难度：简单
  给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
  说明：每次只能向下或者向右移动一步。

  示例:
  输入:
  [
    [1,3,1],
    [1,5,1],
    [4,2,1]
  ]
  输出: 7
  解释: 因为路径 1→3→1→1→1 的总和最小。
*/
var minPathSum = function(grid) {
  // 1. 重复性（分治） problem[i][j] = grid[i, j] + min(problem(i-1, j), problem(i, j-1))
  // 2. 定义状态数组 f[i, j]
  // 3. DP方程 dp[i][j] = dp[i][j] + min(dp[i-1][j], dp[i][j-1])

  if (!grid.length) return 0
  let dp = []
  for (let i = 0; i < grid.length; i++) {
      dp[i] = []
  }
  for (let i = 0; i < grid.length; i++) {
      for (let j = 0; j < grid[0].length; j++) {
          if (i === 0 && j === 0) dp[i][j] = grid[i][j]                   // 起点
          else if (i === 0) dp[i][j] = dp[i][j-1] + grid[i][j]            // 最上面一行
          else if (j === 0) dp[i][j] = dp[i-1][j] + grid[i][j]            // 最左边一列
          else dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j]   // DP方程
      }
  }
  return dp[dp.length-1][dp[0].length-1]
};