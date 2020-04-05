/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @date Apr 5 2020
// class Solution {
//     public boolean isPalindrome(String s) {
//         s = s.toLowerCase();
//         StringBuilder sb = new StringBuilder();
//         for (char c : s.toCharArray()) 
//             if (Character.isLetterOrDigit(c))
//                 sb.append(c);
//         return sb.toString().equals(sb.reverse().toString());
//     }
// }

// @lc code=start
// @date Apr 5 2020
class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        if (s.length() == 0) return true;
        for (int f = 0, r = s.length() - 1; f < r; f ++, r --) 
            if (!Character.isLetterOrDigit(s.charAt(f)))
                r ++;
            else if (!Character.isLetterOrDigit(s.charAt(r))) 
                f --;
            else if (s.charAt(f) != s.charAt(r)) 
                return false;
        return true;
    }
}
// @lc code=end

