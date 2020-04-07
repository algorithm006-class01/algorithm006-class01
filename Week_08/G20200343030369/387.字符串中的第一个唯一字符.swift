/*
 * @lc app=leetcode.cn id=387 lang=swift
 *
 * [387] 字符串中的第一个唯一字符
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (43.14%)
 * Likes:    196
 * Dislikes: 0
 * Total Accepted:    69K
 * Total Submissions: 156.2K
 * Testcase Example:  '"leetcode"'
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 
 * 案例:
 * 
 * 
 * s = "leetcode"
 * 返回 0.
 * 
 * s = "loveleetcode",
 * 返回 2.
 * 
 * 
 * 
 * 
 * 注意事项：您可以假定该字符串只包含小写字母。
 * 
 */

// @lc code=start
class Solution {
    func firstUniqChar(_ s: String) -> Int {
        
    }

    func firstUniqCharIter(_ s: String) -> Int {
        var map = [Character: Int]()
        
        for c in s {
            if let count = map[c] {
                map[c] = count + 1
            } else {
                map[c] = 1
            }
        }
        for c in s {
            if map[c] == 1 {
                return s.distance(from: s.firstIndex(of: s.first!)!, to: s.firstIndex(of: c)!)
            }
        }
        return -1
    }

    func firstUniqCharIter2(_ s: String) -> Int {
        var alphabet = Array(repeating: 0, count: 26)
        let a = Int(("a" as Character).asciiValue!)
        for c in s.unicodeScalars {
            alphabet[Int(c.value) - a] += 1
        }

        var i = 0
        for c in s.unicodeScalars {
            if alphabet[Int(c.value) - a] == 1 {
                return i
            }
            i += 1
        }
        return -1
    }
}
// @lc code=end

