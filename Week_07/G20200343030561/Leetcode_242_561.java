import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if (s.length() != t.length()) return false;
//         int [] counter = new int[26];
//         for (int i = 0; i < s.length(); i ++) {
//             counter[s.charAt(i) - 'a'] ++;
//             counter[t.charAt(i) - 'a'] --;
//         }

//         for(int ch : counter) {
//             if (ch != 0) 
//                 return false;
//         }
//         return true;
//     }
// }

// @date Mar 04 2020
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         char[] sa = s.toCharArray();
//         char[] ta = t.toCharArray();
//         Arrays.sort(sa);
//         Arrays.sort(ta);
//         return Arrays.equals(sa, ta);
//     }
// }

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if (s.length() != t.length()) return false;
//         int[] alphabet = new int[26];
//         for (int i = 0; i < s.length(); i ++) {
//             alphabet[s.charAt(i) - 'a'] ++;
//             alphabet[t.charAt(i) - 'a'] --;
//         }
//         for(int c: alphabet) 
//             if (c != 0) return false;
//         return true;
//     }
// }

// @date Mar 27 2020
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] as = s.toCharArray();
        char[] at = t.toCharArray();
        Arrays.sort(as);
        Arrays.sort(at);
        return Arrays.equals(as, at);
    }
}

// @lc code=end

