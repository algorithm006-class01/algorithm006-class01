import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    // 排序
    public boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        Arrays.sort(c1);
        char[] c2 = t.toCharArray();
        Arrays.sort(c2);
        // if (c1.length != c2.length) return false;
        // for (int i = 0; i < c1.length; ++i) if (c1[i] != c2[i]) return false;
        // return true;
        return String.valueOf(c1).equals(String.valueOf(c2));
    }

    // 题解的一种，效率也不高
    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) return false;
    //     int[] nums1 = new int[26];

    //     for (int i = 0; i < s.length(); ++i){
    //         nums1[s.charAt(i)-'a']++;
    //         nums1[t.charAt(i)-'a']--;
    //     }

    //     for (int i : nums1) if (i!=0) return false;
    //     return true;
    // }
}
// @lc code=end

