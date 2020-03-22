class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int si = s.length - 1;
        int gi = g.length - 1;
        while (gi >= 0 && si >= 0) {
            if (g[gi] <= s[si]) {
                si --;
            }
            gi --;
        }
        return s.length - 1 - si;
    }
}