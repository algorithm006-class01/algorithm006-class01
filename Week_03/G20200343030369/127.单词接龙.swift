/*
 * @lc app=leetcode.cn id=127 lang=golang
 *
 * [127] 单词接龙
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (39.53%)
 * Likes:    218
 * Dislikes: 0
 * Total Accepted:    23.5K
 * Total Submissions: 58.4K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出: 5
 * 
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * ⁠    返回它的长度 5。
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: 0
 * 
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * 
 */

// @lc code=start
class Solution {
    func ladderLength(_ beginWord: String, _ endWord: String, _ wordList: [String]) -> Int {

    }

    func findAdjacents(_ start: String, _ wordList: [String]) -> [String] {
      var adjacents = [String]()
      for word in wordList {
        let wordChar = [Character](word)
        let startChar = [Character](start)
        var diff = 0
        for i in 0..<startChar.count where startChar[i] != wordChar[i] {
          diff += 1
          if diff > 1 {break}
        }
        if diff == 1 {adjacents.append(word)}
      }
      return adjacents
    }

    // BFS
    func ladderLength0(_ beginWord: String, _ endWord: String, _ wordList: [String]) -> Int {
        var queue = [(String, Int)]()
        var visited = Set<String>()
        queue.append((beginWord, 0))

        while !queue.isEmpty {
          let (word, level) = queue.removeFirst()
          visited.insert(word)
          if word == endWord {return level}
          for adj in findAdjacents(word, wordList) where !visited.contains(adj) {
            queue.append((adj, level + 1))
          }
        }
        return -1
    }

    //
    func ladderLength1(_ beginWord: String, _ endWord: String, _ wordList: [String]) -> Int {
      var allCombosDict = [String: [String]]()
      var queue = [(String, Int)]()
      var visited = Set<String>()
      // 预处理
      for word in wordList {
        for i in 0..<word.count {
          var wordChar = [Character](word)
          wordChar[i] = "*"; let key = String(wordChar)
          var combos: [String]
          if allCombosDict[key] == nil {
            combos = [String]()
          } else {
            combos = allCombosDict[key]!
          }
          combos.append(word)
          allCombosDict[key] = combos
        }
      }

      queue.append((beginWord, 1))
      while !queue.isEmpty {
        let (word, level) = queue.removeFirst()
        visited.insert(word)
        if word == endWord {return level}
        for i in 0..<word.count {
          var wordChar = [Character](word)
          wordChar[i] = "*"; let key = String(wordChar)
          if let combos = allCombosDict[key] {
            for adj in combos where !visited.contains(adj) {
              queue.append((adj, level + 1))
            }
          }
        }
      }
      return 0
    }
}
// @lc code=end

