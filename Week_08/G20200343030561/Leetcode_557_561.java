/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @date Apr 5 2020
// class Solution {
//     public String reverseWords(String s) {
//         String[] words = s.split(" ");
//         StringBuilder res = new StringBuilder();
//         for (String word: words) {
//             res.append(new StringBuffer(word).reverse().toString());
//             res.append(" ");
//         }
//         return res.toString().trim();
//     }
// }

// @lc code=start
// @date Apr 5 2020
class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) != ' ')
                word.append(s.charAt(i));
            else {
                res.append(word.reverse());
                res.append(" ");
                word.setLength(0);
            }
        }
        return res.append(word.reverse()).toString();
    }
}
// @lc code=end

