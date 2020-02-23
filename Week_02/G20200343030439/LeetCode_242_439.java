import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (57.64%)
 * Likes:    159
 * Dislikes: 0
 * Total Accepted:    75.7K
 * Total Submissions: 129.3K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start
class Solution {
    public static void main(String[] args) {

        System.out.println(isAnagram2("anagram", "nagaram"));
        System.out.println(isAnagram2("rat", "car") ? "true" : "false");

        /*
         * for (int i = 0; i < result.length; i++) { System.out.println(result[i]); }
         */
    }

    // 方法一：排序
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        return Arrays.equals(str1, str2);
    }

    // 方法二：哈希表
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            table[index]--;
            if (table[index] < 0) {
                return false;
            }
        }
        return true;
    }

    // 
    public static boolean isAnagram3(String s, String t) {
        int[] counts=new int[26];
        for(char ch:s.toCharArray()){
            counts[ch-'a']++;
        }
        for(char ch:t.toCharArray()){
            counts[ch-'a']--;
        }
        for(int i:counts){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

