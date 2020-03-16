package G20200343030391;

import java.util.Arrays;

public class LeetCode_455_391 {

    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        int contentChildren = new LeetCode_455_391().findContentChildren_1(g, s);
        System.out.println(contentChildren);
    }

    /**
     * 贪心，最小饼干分给胃口最小的
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren_1(int[] g, int[] s) {
        if (g == null || g.length == 0 || s == null || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while(gi < g.length && si < s.length){
            //满足一个
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

}
