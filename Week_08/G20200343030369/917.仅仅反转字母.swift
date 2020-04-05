/*
 * @lc app=leetcode.cn id=917 lang=swift
 *
 * [917] 仅仅反转字母
 *
 * https://leetcode-cn.com/problems/reverse-only-letters/description/
 *
 * algorithms
 * Easy (52.91%)
 * Likes:    43
 * Dislikes: 0
 * Total Accepted:    10.3K
 * Total Submissions: 19.1K
 * Testcase Example:  '"ab-cd"'
 *
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 
 * 
 * 示例 2：
 * 
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 
 * 
 * 示例 3：
 * 
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S 中不包含 \ or "
 * 
 * 
 */

// @lc code=start
class Solution {
    func reverseOnlyLetters(_ S: String) -> String {
        
    }

    func reverseOnlyLettersIter(_ s: String) -> String {
        var chars = [Character](s)
        var i = 0, j = chars.count - 1
        while i < j {
            if chars[i].isLetter && chars[j].isLetter {
                let t = chars[i]
                chars[i] = chars[j]
                chars[j] = t
                i += 1; j -= 1
            } else if chars[i].isLetter {
                j -= 1
            } else {
                i += 1
            }
        }
        return String(chars)
    }
}
// @lc code=end

