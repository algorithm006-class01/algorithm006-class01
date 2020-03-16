/*
 * @lc app=leetcode.cn id=64 lang=golang
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (64.49%)
 * Likes:    403
 * Dislikes: 0
 * Total Accepted:    66.4K
 * Total Submissions: 102.3K
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

// @lc code=start
class Solution {
    func minPathSum(_ grid: [[Int]]) -> Int {

    }

    func minPathSumDP(_ grid: [[Int]]) -> Int {
      guard grid.count > 0 && grid[0].count > 0 else {return 0}
      let n = grid.count, m = grid[0].count
      var minPath = Array(repeating: Array(repeating: 0, count: m), count: n)
      minPath[0][0] = grid[0][0]
      for i in 1..<n {
        minPath[i][0] = minPath[i-1][0] + grid[i][0]
      }
      for j in 1..<m {
        minPath[0][j] = minPath[0][j-1] + grid[0][j]
      }

      for i in 1..<n {
        for j in 1..<m {
          minPath[i][j] = min(minPath[i-1][j], minPath[i][j-1]) + grid[i][j]
        }
      }
      return minPath[n-1][m-1]
    }
}
// @lc code=end

