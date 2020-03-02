class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int g1 = 0, s1 = 0;
        while (g1 < g.length && s1 < s.length) {
            if (g[g1] <= s[s1]) {
                g1++;
                s1++;
            } else {
                s1++;
            }
        }
        return g1;
    }
}
