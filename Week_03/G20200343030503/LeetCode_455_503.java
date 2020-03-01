
class Solution {
    //g grid  s size
    public int findContentChildren(int[] g, int[] s) {
        //将饼干和孩子降序排序
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0;
        int si = 0;
        while (gi < g.length && si < s.length ) {
            //最大的饼干满足胃口最大的孩子，饼干就给他，否则这孩子只能饿着，把最大的饼干分给下一个胃口第二大的孩子
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}