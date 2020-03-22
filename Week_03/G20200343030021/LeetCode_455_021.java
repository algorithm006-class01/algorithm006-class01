import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1, 1, 2, 1}));
    }

    public static int findContentChildren(int[] g, int[] s) {
//        整体思路：贪心算法，将小饼干给胃口最小的小朋友
//        题目限定条件：一个小朋友最多一个饼干
//        排序
        Arrays.sort(g);
        Arrays.sort(s);
        int g1 = 0, s1 = 0;
        while (g1 < g.length && s1 < s.length) {
            if (g[g1] <= s[s1]) {
                g1++;
            }
            s1++;
        }
        return g1;
    }
}