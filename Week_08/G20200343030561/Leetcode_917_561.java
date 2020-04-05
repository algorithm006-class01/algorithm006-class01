/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
// @date Apr 5 2020
class Solution {
    public String reverseOnlyLetters(String S) {
        StringBuilder res = new StringBuilder();
        int len = S.length();
        for (int i = 0, j = len - 1; i < len; i ++) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j)))
                    j --;
                res.append(S.charAt(j --));
            } else 
                res.append(S.charAt(i));
        }
        return res.toString();
    }
}
// @lc code=end

