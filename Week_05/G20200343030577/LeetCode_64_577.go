package leetcode

/*
 * @lc app=leetcode.cn id=64 lang=golang
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (64.44%)
 * Likes:    403
 * Dislikes: 0
 * Total Accepted:    66.4K
 * Total Submissions: 102.4K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 *
 */
// create time: 2020-03-15 22:07
// @lc code=start
func minPathSum(grid [][]int) int {
	return minPathSumDP(grid)
}

func minPathSumDP(grid [][]int) int {
	// 处理边界
	if len(grid) == 0 || len(grid[0]) == 0 {
		return 0
	}
	min := func(a, b int) int {
		if a < b {
			return a
		}
		return b
	}
	// 构造dp空间
	m, n := len(grid), len(grid[0])
	dp := make([]int, n)
	// 初始化dp
	dp[0] = grid[0][0]
	for i := 1; i < n; i++ {
		dp[i] = dp[i-1] + grid[0][i]
	}
	// 递推
	for i := 1; i < m; i++ {
		dp[0] += grid[i][0]
		for j := 1; j < n; j++ {
			dp[j] = grid[i][j] + min(dp[j], dp[j-1])
		}
	}
	return dp[n-1]
}

// @lc code=end
