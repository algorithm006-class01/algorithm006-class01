import java.util.*;
/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @date Apr 5 2020
// class Solution {
//     public String reverseWords(String s) {
//         s = s.trim();
//         List<String> wordList = Arrays.asList(s.split("\\s+"));
//         Collections.reverse(wordList);
//         return String.join(" ", wordList);
//     }
// }

// @lc code=start
// @date Apr 5 2020
// @solution deque
class Solution {
    public String reverseWords(String s) {
        int l = 0, r = s.length() - 1;
        for (;l <= r && s.charAt(l) == ' '; l ++);
        for (;l <= r && s.charAt(r) == ' '; r --);
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        while (l <= r) {
            char c = s.charAt(l);
            if (word.length() != 0 && c == ' ') {
                deque.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ')
                word.append(c);
            l ++;
        }
        deque.offerFirst(word.toString());
        return String.join(" ", deque);
    }
}
// @lc code=end

