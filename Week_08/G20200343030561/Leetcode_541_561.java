/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
// @date Apr 5 2020
class Solution {
    public String reverseStr(String s, int k) {
        char[] letters = s.toCharArray();
        for (int i = 0; i < letters.length; i += 2 * k) {
            int j = Math.min(i + k - 1, letters.length - 1);
            int t = i;
            while (i < j) {
                char temp = letters[i];
                letters[i++] = letters[j];
                letters[j--] = temp;
            }
            i = t;
        }
        return String.valueOf(letters);
    }
}
// @lc code=end

