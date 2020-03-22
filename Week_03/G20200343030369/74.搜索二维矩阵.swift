/*
 * @lc app=leetcode.cn id=74 lang=golang
 *
 * [74] 搜索二维矩阵
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (37.29%)
 * Likes:    136
 * Dislikes: 0
 * Total Accepted:    32.8K
 * Total Submissions: 87.5K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 
 * 
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    func searchMatrix(_ matrix: [[Int]], _ target: Int) -> Bool {

    }

    func searchMatrix0(_ matrix: [[Int]], _ target: Int) -> Bool {
      if maxtrix.count == 0 {return false}
      let n = matrix.count, m = matrix[0].count
      var left = 0, right = n * m - 1
      while left <= right {
        let mid = left + (right - left) / 2
        let r = mid / m, c = mid % m
        if matrix[r][c] == target {return true}
        if matrix[r][c] > target {
          right = mid - 1
        } else {
          left = mid + 1
        }
      }
      return false
    }
}
// @lc code=end

