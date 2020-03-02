import java.util.*;
/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int kid = 0;
        int biscuit = 0;
        while (kid < g.length && biscuit < s.length)
            if (g[kid] <= s[biscuit ++]) kid ++;
        
        return kid;
    }
}
// @lc code=end

