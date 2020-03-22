class LeetCode_455_505 {
   public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0, count = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                ++i;
                ++j;
                ++count;
            } else {
                ++j;
            }
        }

        return count;
    }
}