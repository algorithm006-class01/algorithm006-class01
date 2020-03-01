/*
 * @lc app=leetcode.cn id=77 lang=golang
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (72.62%)
 * Likes:    220
 * Dislikes: 0
 * Total Accepted:    35K
 * Total Submissions: 48K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */

// @lc code=start
class Solution {
    func combine(_ n: Int, _ k: Int) -> [[Int]] {

    }

    func combine0(_ n: Int, _ k: Int) -> [[Int]] {

    }

    func _helper(_ i: Int, _ n: Int, _ k: Int) -> [[Int]] {
      var res: [[Int]] = Array()
      if k == 1 {
        for j in i...n {
          res.append([j])
        }
        return res
      }


      for j in i...n-k+1 {
        for arr in _helper(j + 1, n, k - 1) {
           res.append([j] + arr)
        }
      }
      return res
    }
}
// @lc code=end

