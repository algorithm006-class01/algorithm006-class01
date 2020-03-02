package week3.assign_cookies;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(g == null || s == null) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int n = 0;
        for (int a=0;a<g.length;a++){
            for (int b=0;b<s.length;b++){
                if (g[a]<=s[b]){
                    n++;
                    s[b]=-1;
                    break;
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] g={1,2,3};
        int[] s={1,1};
        Solution solution = new Solution();
        System.out.println(solution.findContentChildren(g,s));
    }
}
