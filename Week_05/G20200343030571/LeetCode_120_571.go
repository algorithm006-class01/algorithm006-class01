package main

/*
 * @lc app=leetcode.cn id=120 lang=golang
 *
 * [120] 三角形最小路径和
 *
 * https://leetcode-cn.com/problems/triangle/description/
 *
 * algorithms
 * Medium (63.78%)
 * Likes:    333
 * Dislikes: 0
 * Total Accepted:    44.5K
 * Total Submissions: 69.6K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 *
 *
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 */

// @lc code=start

/*
	dp[i,j] = dp[i,j] + min(dp[i+1,j], dp[i+1,j+1])
*/
/* func minimumTotal(triangle [][]int) int {
	row := len(triangle)
	dp := make([][]int, row)
	copy(dp, triangle)

	for i := row - 2; i >= 0; i-- {
		for j := range dp[i] {
			dp[i][j] = dp[i][j] + minInt(dp[i+1][j], dp[i+1][j+1])
		}
	}
	return dp[0][0]

} */

/* 空间优化：将dp数组简化为一维 */
func minimumTotal(triangle [][]int) int {
	row := len(triangle)
	maxCol := len(triangle[row-1])
	dp := make([]int, maxCol)
	copy(dp, triangle[row-1])

	for i := row - 2; i >= 0; i-- {
		for j := 0; j < len(triangle[i]); j++ {
			dp[j] = triangle[i][j] + minInt(dp[j], dp[j+1])
		}
	}
	return dp[0]
}

func minInt(x, y int) int {
	if x < y {
		return x
	}
	return y
}

/* func main() {
	inPut := [][]int{{1}, {2, 3}}
	println(minimumTotal(inPut))
}
*/
// @lc code=end
