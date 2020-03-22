import java.util.*;
/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @date Mar 15 2020
// class Solution {
//     public String minWindow(String s, String t) {
//         if (s.length() == 0 || t.length() == 0) return "";
//         Map<Character, Integer> mapT = new HashMap<>();
//         for (int i = 0; i < t.length(); i ++) 
//             mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        
//         int sizeT = mapT.size(), left = 0, right = 0, formed = 0;
//         Map<Character, Integer> window = new HashMap<>();
//         int[] ans = {-1, 0, 0};

//         while (right < s.length()) {
//             char c = s.charAt(right);
//             window.put(c, window.getOrDefault(c, 0) + 1);
//             if(mapT.containsKey(c) && window.get(c).intValue() == mapT.get(c).intValue()) 
//                 formed ++;
//             while (left <= right && formed == sizeT) {
//                 if (ans[0] == -1 || right - left + 1 < ans[0]) {
//                     ans[0] = right - left + 1;
//                     ans[1] = left;
//                     ans[2] = right;
//                 }
//                 c= s.charAt(left);
//                 window.put(c, window.get(c) - 1);
//                 if(mapT.containsKey(c) && window.get(c).intValue() < mapT.get(c).intValue()) 
//                     formed -- ;
//                 left ++;
//             }
//             right ++;
//         }
//         return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
//     }
// }

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[128];
        for (char c : t.toCharArray())
            count[c - '\0'] ++;
        int len = 0, minLen = s.length(); // formed, ans[0]
        String res = new String();
        for (int left = 0, right = 0; right < s.length(); right ++) {
            if (-- count[s.charAt(right) - '\0'] >= 0) len ++;
            while (len == t.length()) {
                if (right - left + 1 <= minLen) {
                    minLen = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                if (++ count[s.charAt(left++)] > 0) len --;
            }
        }
        return res;
    }
}
// @lc code=end

