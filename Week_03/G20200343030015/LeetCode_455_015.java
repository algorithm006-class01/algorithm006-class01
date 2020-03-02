package G20200343030015.week_03;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * site:: https://leetcode-cn.com/problems/assign-cookies/description/
 * Created by majiancheng on 2020/3/2.
 */
public class LeetCode_455_015 {
    public int findContentChildren(int[] g, int[] s) {
        if(g.length == 0 || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0;
        int si = 0;
        int res = 0;
        while(gi < g.length && si < s.length) {
            if(s[si] >= g[gi]) {
                si ++;
                gi ++;
                res ++;
            } else {
                si ++;
            }
        }

        return res;
    }
}
