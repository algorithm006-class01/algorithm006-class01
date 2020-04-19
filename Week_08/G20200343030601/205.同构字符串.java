/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 *
 * https://leetcode-cn.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (47.33%)
 * Likes:    179
 * Dislikes: 0
 * Total Accepted:    33.6K
 * Total Submissions: 71K
 * Testcase Example:  '"egg"\n"add"'
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * 
 * 示例 1:
 * 
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 * 
 */

// @lc code=start
class Solution {
    // 解决方案：1.两个map存储映射关系； 或2.用一个map存储映射关系，同时使用containsValue检测是否B值存在；
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public boolean isIsomorphic1(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        HashMap<Character, Character> mapST = new HashMap<>();
        for (int i = 0; i < sChars.length; i++) {
            char c1 = sChars[i];
            char c2 = tChars[i];
            if (mapST.containsKey(c1)) {
                if (mapST.get(c1) != c2) return false;
            } else {
                if (mapST.containsValue(c2)) return false;
                mapST.put(c1, c2);
            }
        }
        return true;
    }

    // 解决方案：记录s和t相同位置的，
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public boolean isIsomorphic(String s, String t) {
        int[] sCharLastPos = new int[256], tCharLastPos = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (sCharLastPos[s.charAt(i)] != tCharLastPos[t.charAt(i)]) return false;
            sCharLastPos[s.charAt(i)] = i + 1;
            tCharLastPos[t.charAt(i)] = i + 1;
        }

        return true;
    }
}
// @lc code=end

