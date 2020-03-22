package greedy;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies
 */
public class AssignCookies01 {

    public int findContentChildren(int[] g, int[] s) {

        if (g == null || s == null) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0;
        int si = 0;
        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                gi++;
            }
            si++;
        }

        return gi;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1, 2, 3};
        int[] s = new int[]{2, 1};

        AssignCookies01 assignCookies = new AssignCookies01();
        System.out.println(assignCookies.findContentChildren(g, s));
    }

}
