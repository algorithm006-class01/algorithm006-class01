/*
 * @lc app=leetcode.cn id=455 lang=golang
 *
 * [455] 分发饼干
 *
 * https://leetcode-cn.com/problems/assign-cookies/description/
 *
 * algorithms
 * Easy (52.81%)
 * Likes:    135
 * Dislikes: 0
 * Total Accepted:    26.1K
 * Total Submissions: 49K
 * Testcase Example:  '[1,2,3]\n[1,1]'
 *
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi
 * ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i
 * ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 
 * 注意：
 * 
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,2,3], [1,1]
 * 
 * 输出: 1
 * 
 * 解释: 
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1,2], [1,2,3]
 * 
 * 输出: 2
 * 
 * 解释: 
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 * 
 * 
 */

// @lc code=start
class Solution {
    func findContentChildren(_ g: [Int], _ s: [Int]) -> Int {
        
    }

    // 原答案 412 ms
    func findContentChildren0(_ g: [Int], _ s: [Int]) -> Int {
      if g.count == 0 || s.count == 0 {return 0}
      let sortedG = g.sorted(), sortedS = s.sorted()
      var gi = 0, sj = 0, satisfies = 0
      while gi < sortedG.count && sj < sortedS.count {
        if sortedG[gi] <= sortedS[sj] {
          satisfies += 1
          gi += 1
          sj += 1
          continue
        }
        if sortedG[gi] > sortedS[sj] {sj += 1}
      }
      return satisfies
    }

    // 用时最少答案 240 ms
    func findContentChildren1(_ g: [Int], _ s: [Int]) -> Int {
      var g = g, s = s
      g.sort(by: <); s.sort(by: <)
      var gi = 0, sj = 0, satisfies = 0
      while gi < g.count && sj < s.count {
        if g[gi] <= s[sj] {
          satisfies += 1
          gi += 1
          sj += 1
          continue
        }
        if g[gi] > s[sj] {sj += 1}
      }
      return satisfies
    }
}
// @lc code=end

