/*
 * @lc app=leetcode.cn id=49 lang=golang
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (60.66%)
 * Likes:    269
 * Dislikes: 0
 * Total Accepted:    51.1K
 * Total Submissions: 84.1K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */

// @lc code=start
class Solution {
  func groupAnagrams(_ strs: [String]) -> [[String]] {

  }

  // 哈希表
  func groupAnagrams0(_ strs: [String]) -> [[String]] {
    var groups: [String: [String]] = Dictionary()
    for s in strs {
      let key = String(s.sorted())
      var g: [String]
      if groups[key] != nil {
        g = [String](groups[key]!)
      } else {
        g = Array()
      }
      g.append(s)
      groups[key] = g
    }
    return [[String]](groups.values)
  }
}

// @lc code=end

