class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // 贪心算法，双指针法 时间复杂度O(n)
        if (g.length == 0 || s.length == 0){
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int i = 0;
        int j = 0;

        while (i != g.length && j != s.length){
            if (s[j] >= g[i]){
                count++;
                i++;
            } 
            j++;
        }
        return count;
    }
}