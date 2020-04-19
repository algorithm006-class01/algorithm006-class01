/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (36.27%)
 * Likes:    158
 * Dislikes: 0
 * Total Accepted:    60.1K
 * Total Submissions: 144.7K
 * Testcase Example:  '"the sky is blue"'
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 
 * 
 * 示例 2：
 * 
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 
 * 
 * 示例 3：
 * 
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 
 * 
 * 
 * 
 * 说明：
 * 
 * 
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 * 
 */

// @lc code=start
class Solution {
    // 解决方案：split + reverse + join
    // 时间复杂度：O(N)
    // 空间复杂度：O(N)
    public String reverseWords1(String s) {
        List<String> wordList = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    // 解决方案：two-end queue
    // 时间复杂度：O(N) N为输入字符串的长度
    // 空间复杂度：O(N) 双端队列存储单词需要的空间
    public String reverseWords2(String s) {
        int left = 0, right = s.length() - 1;
        
        // 去掉字符串头部空白字符 和 尾部空白字符
        while (left <= right && s.charAt(left) == ' ') left++;
        while (left <= right && s.charAt(right) == ' ') right--;

        Deque<String> deque = new ArrayDeque();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char ch = s.charAt(left);            
            if (word.length() != 0 && ch == ' ') { // 一个word结束，插入队列头部
                deque.offerFirst(word.toString());
                word.setLength(0);
            } else if (ch != ' ') { // 当前word还未结束，继续拼接当前word
                word.append(ch);
            } // else 连续的‘ ’，忽略连续的空白字符
            ++left;
        }
        deque.offerFirst(word.toString());  // 因为已经处理完了尾部字符，所以最后word肯定不空

        return String.join(" ", deque);
    }

    // 解决方案：手工实现
    // 时间复杂度：O(N) N为输入字符串的长度
    // 空间复杂度：O(N) 双端队列存储单词需要的空间
    public String reverseWords(String s) {
        // 清除首尾和中间多余的空格
        StringBuilder sb = trimSpaces(s);
        // 反转字符串
        reverse(sb, 0, sb.length() -1);
        // 反转每个单词
        reverseEachWord(sb);
        return sb.toString();          
    }

    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        while(left <= right && s.charAt(left) == ' ') ++left;
        while(left <= right && s.charAt(right) == ' ') --right;

        StringBuilder sb = new StringBuilder();
        while(left <= right) {
            char ch = s.charAt(left);
            if (ch != ' ') sb.append(ch);
            else if (sb.charAt(sb.length() - 1) != ' ') sb.append(ch); // word间只留一个空格
            
            ++left;
        }

        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tempCh = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tempCh);
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length(), start = 0, end = 0;

        while (start < n) {
            // 找到每个word的末尾
            while (end < n && sb.charAt(end) != ' ') ++end;
            // 反转单词
            reverse(sb, start, end - 1);
            // 更新start，去找下一个word
            start = end + 1;
            ++end;
        }
    }
}
// @lc code=end

