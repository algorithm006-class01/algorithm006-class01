/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i ++, j --)
            if (s.charAt(i) != s.charAt(j))
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
        return true;
    }
    boolean isPalindrome(String s, int i, int j) {
        while (i < j) 
            if (s.charAt(i ++) != s.charAt(j --)) 
                return false;
        return true;
    }
}
// @lc code=end

