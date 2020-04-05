/*
 * @lc app=leetcode.cn id=205 lang=swift
 *
 * [205] 同构字符串
 *
 * https://leetcode-cn.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (47.17%)
 * Likes:    176
 * Dislikes: 0
 * Total Accepted:    33.2K
 * Total Submissions: 70.2K
 * Testcase Example:  '"egg"\n"add"'
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * 
 * 示例 1:
 * 
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 * 
 */

// @lc code=start
class Solution {
    func isIsomorphic(_ s: String, _ t: String) -> Bool {

    }

    func isIsomorphicIter(_ s: String, _ t: String) -> Bool {
        var map = [Character: Character]()
        let sChars = [Character](s), tChars = [Character](t)
        for i in 0..<s.count {
            if !map.keys.contains(sChars[i]) {
                if map.values.contains(tChars[i]) {
                    return false
                }
                map[sChars[i]] = tChars[i]
            } else if map[sChars[i]] != map[tChars[i]] {
                return false
            }
        }
        return true
    }

    func isIsomorphicGeneratingArray(_ s: String, _ t: String) -> Bool {
        func generateArray(_ s: String) -> [Int] {
            var res = [Int]()
            var dict = [String.Element: Int]()
            var index = 0
            for x in s {
                if let y = dict[x] {
                    res.append(y)
                } else {
                    dict[x] = index
                    res.append(index)
                    index += 1
                }
            }
            return res
        }

        return generateArray(s) == generateArray(t)
    }

    func isIsomorphicMapSet(_ s: String, _ t: String) -> Bool {
        let sArr = Array(s)
        let tArr = Array(t)
        var map = [Character:Character]()
        var set = Set<Character>()
        for i in 0..<sArr.count{
            let sc = sArr[i]
            let tc = tArr[i]
            if let tmp = map[sc] {
                if tmp != tc {
                    return false
                }
            }else {
                if set.contains(tc) {
                    return false
                }
                map[sc] = tc
                set.insert(tc)
            }
        }
        return true        
    }
}
// @lc code=end

