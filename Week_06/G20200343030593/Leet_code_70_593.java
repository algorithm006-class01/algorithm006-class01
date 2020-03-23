class Solution {
    Map<Integer,Integer> m=new HashMap();
    public int climbStairs(int n) {
        if(n==1||n==2){
            return n;
        }
        Integer v=m.get(n);
        if(v==null){
            v=climbStairs(n-1)+climbStairs(n-2);
            m.put(n,v);
        }
        return v;
    }
}