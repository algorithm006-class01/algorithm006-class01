/*
 * @lc app=leetcode.cn id=72 lang=golang
 *
 * [72] 编辑距离
 *
 * https://leetcode-cn.com/problems/edit-distance/description/
 *
 * algorithms
 * Hard (56.19%)
 * Likes:    572
 * Dislikes: 0
 * Total Accepted:    33.2K
 * Total Submissions: 58.8K
 * Testcase Example:  '"horse"\n"ros"'
 *
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 
 * 你可以对一个单词进行如下三种操作：
 * 
 * 
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 
 * 
 * 示例 1:
 * 
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释: 
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 
 * 
 * 示例 2:
 * 
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释: 
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * 
 * 
 */

// @lc code=start
class Solution {
    func minDistance(_ word1: String, _ word2: String) -> Int {

    }

    func minDistanceBT(_ word1: String, _ word2: String) -> Int {
      let word1 = [Character](word1), word2 = [Character](word2)
      let n = word1.count, m = word2.count
      var ans = max(n, m)
      func lwsBT(_ i: Int, _ j: Int, _ editest: Int) {
        if i == n || j == m {
          var editest = editest
          if i < n {editest += n - i}
          if j < m {editest += m - j}
          if editest < ans {ans = editest}
        }

        // 字符相等就跳过
        if word1[i] == word2[i] {
          lwsBT(i+1, j+1, editest)
        } else { // 字符不等的处理方法
        // 删除 i 或者在 i 位置插入
          lwsBT(i+1, j, editest+1)
        // 删除 j 或者在 j 位置插入
          lwsBT(i, j+1, editest+1)
        // 替换 i 或者 j
          lwsBT(i+1, j+1, editest+1)
        }
      }

      lwsBT(0, 0, 0)
      return ans
    }

    func minDistanceDP(_ word1: String, _ word2: String) -> Int {
      let word1 = [Character](word1), word2 = [Character](word2)
      let n = word1.count, m = word2.count
      var minDist = Array(repeating: Array(repeating: 0, count: m), count: n)
      for i in 0..<n {
        if word1[i] == word2[0] {
          minDist[i][0] = i
        } else if i != 0 {
          minDist[i][0] = minDist[i-1][0] + 1
        } else {
          minDist[i][0] = 1
        }
      }

      for j in 0..<m {
        if word1[0] == word2[j] {
          minDist[0][j] = j
        } else if j != 0 {
          minDist[0][j] = minDist[0][j-1] + 1
        } else {
          minDist[0][j] = 1
        }
      }

      func min(_ dist1: Int, _ dist2: Int, _ dist3: Int) -> Int {
        var minv = Int.max
        if dist1 < minv {minv = dist1}
        if dist2 < minv {minv = dist2}
        if dist3 < minv {minv = dist3}
        return minv
      }

      for i in 1..<n {
        for j in 1..<m {
          if word1[i] == word2[j] {
            minDist[i][j] = min(minDist[i-1][j]+1, minDist[i][j-1]+1, minDist[i-1][j-1])
          } else {
            minDist[i][j] = min(minDist[i-1][j]+1, minDist[i][j-1]+1, minDist[i-1][j-1]+1)
          }
        }
      }
      return minDist[n-1][m-1]
    }
}
// @lc code=end

