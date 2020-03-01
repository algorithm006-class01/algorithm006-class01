class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // 结果
        int result = 0;
        // 边界条件
        if (null == g || g.length == 0
                || null == s || s.length == 0){
            return result;
        }
        // 排序，减少后续循环对比工作量
        Arrays.sort(g);
        Arrays.sort(s);

        for (int i = 0, j = 0; i < s.length && j < g.length; ) {
            // 如果当前饼干大小满足当前小孩胃口，则结果+1，继续下一个小孩
            if (g[j] <= s[i]){
                result++;
                j++;
            }
            // 不管当前饼干是否满足都要取下一个饼干：如果不满足，则加大饼干的大小，取下一个看是否满足；如果满足，进行下一个饼干判断
            i++;
        }
        return result;
    }
}