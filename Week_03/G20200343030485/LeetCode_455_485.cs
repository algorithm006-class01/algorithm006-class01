public class Solution {
    public int FindContentChildren(int[] g, int[] s) {
        Array.Sort(g);
        Array.Sort(s);

        int result = 0;
        int indexS = 0;
        for (int i = 0; i < g.Length; i++) {
            while (indexS < s.Length) {
                int amount = s[indexS];
                indexS++;
                
                if (amount >= g[i]) {
                    result++;
                    break;
                }
            }
        }

        return result;
    }
}