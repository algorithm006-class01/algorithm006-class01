class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int gp = 0;
        int sp = 0;
        while(gp<g.length && sp<s.length){
            if(s[sp] >= g[gp]){
                sp++;
                gp++;
                count++;
            }else{
                sp ++;
            }
        }
        return count;
    }
}