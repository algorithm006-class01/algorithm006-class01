
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
        
        int g_step = 0, s_step = 0, count = 0;

        while (g_step < g.length && s_step < s.length){
            if (g[g_step] <= s[s_step]){
                g_step++;
                s_step++;
                count++;
            }else{
                s_step++;
            }
        }

        return count;
    }
}
// @lc code=end

