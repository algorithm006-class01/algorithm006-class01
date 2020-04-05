/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
// class Solution {
//     public int lengthOfLastWord(String s) {
//         char[] str = s.trim().toCharArray();
//         int len = str.length;
//         if (len == 0) return 0;
//         for (int i = len - 1; i >= 0; i --) 
//             if (str[i] == ' ') 
//                 return len - 1 - i;
//         return len;
//     }
// }

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.substring(s.lastIndexOf(" ") + 1).length();
    }
}
// @lc code=end

