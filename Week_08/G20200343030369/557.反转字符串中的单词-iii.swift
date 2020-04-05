/*
 * @lc app=leetcode.cn id=557 lang=swift
 *
 * [557] 反转字符串中的单词 III
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/description/
 *
 * algorithms
 * Easy (69.22%)
 * Likes:    165
 * Dislikes: 0
 * Total Accepted:    48.9K
 * Total Submissions: 69.8K
 * Testcase Example:  '"Let\'s take LeetCode contest"'
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 
 * 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * 
 */

// @lc code=start
class Solution {
    func reverseWords(_ s: String) -> String {
        
    }

    func reverseWordsIter(_ s: String) -> String {
        var words = s.split(separator: " ")
        func reverse(_ w: [Character]) -> [Character] {
            var w = w, i = 0, j = w.count - 1
            while i < j {
                let tmp = w[i]
                w[i] = w[j]
                w[j] = tmp
                i += 1; j -= 1
            }
            return w
        }
        for i in 0..<words.count {
            words[i] = Substring(reverse([Character](words[i])))
        }
        return words.joined(separator: " ")
    }

    func reverseWordsFunc(_ s: String) -> String {
        return s.split(separator: " ").map{ [Character]($0) }.map{ String($0.reversed()) }.joined(separator: " ")
    }
}
// @lc code=end

