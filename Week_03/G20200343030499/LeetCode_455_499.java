/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int gp = 0;
        int sp = 0;
        while (gp < g.length && sp < s.length) {
            if (s[sp] >= g[gp]) {
                result++;
                sp++;
                gp++;
                continue;
            }
            sp++;
        }
        return result;
    }
}
// @lc code=end
