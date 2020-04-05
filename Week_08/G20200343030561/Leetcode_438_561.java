import java.util.*;
/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
//         List<Integer> res = new ArrayList<>();
//         if (s == null || s.length() == 0 || p == null || p.length() == 0) 
//             return res;
//         int[] inP = new int[26];
//         int[] window = new int[26];
//         int l = 0, r = 0, unmatched = p.length();
//         for (char c : p.toCharArray()) 
//             inP[c - 'a'] ++;
//         for (char right : s.toCharArray()) {
//             if (inP[right - 'a'] > 0) {
//                 window[right - 'a'] ++;
//                 if (window[right - 'a'] <= inP[right - 'a']) 
//                     unmatched --;
//             }
//             while (unmatched == 0) {
//                 if (r - l + 1 == p.length())
//                     res.add(l);
//                 char left = s.charAt(l);
//                 if (inP[left - 'a'] > 0) {
//                     window[left - 'a'] --;
//                     if (window[left - 'a'] < inP[left - 'a'])
//                         unmatched ++;
//                 }
//                 l ++;
//             }
//             r ++;
//         }
//         return res;
//     }   
// }

// @lc code=start
// @date Apr 5 2020
class Solution {
    public List<Integer> findAnagrams(String s, String p)  {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length())
            return res;
        int [] inP = new int[26];
        for (char c: p.toCharArray()) 
            inP[c - 'a'] ++;
        int[] window = new int[26];
        for (int i = 0; i < p.length(); i ++) 
            window[s.charAt(i) - 'a'] ++;
        if (Arrays.equals(window, inP)) 
            res.add(0);
        for (int l = 0, r = p.length(); r < s.length(); l ++, r ++) {
            window[s.charAt(l) - 'a'] --;
            window[s.charAt(r) - 'a'] ++;
            if (Arrays.equals(window, inP)) {
                res.add(l + 1);
            }
        }
        return res;
    }
}
// @lc code=end

