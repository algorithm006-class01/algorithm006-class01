package Week_03.G20200343030395;

import java.util.Arrays;

public class LeetCode_3_395 {
    public int findContentChildren(int[] g, int[] s) {
        int child = 0, cookie = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        while(child < g.length && cookie < s.length) {
            if(g[child] <= s[cookie]) {
                child++;
            }

            cookie ++;
        }

        return child;
    }
}
