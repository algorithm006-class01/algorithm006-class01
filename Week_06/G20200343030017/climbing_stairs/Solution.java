package week6.climbing_stairs;

public class Solution {
    // f(n)=f(n-1)+f(n-2);
    public int climbStairs(int n) {
        if (n<3) return n;
        int[] sum = new int[n+1];
        sum[0]=0;
        sum[1]=1;
        sum[2]=2;
        for (int t=3;t<=n;t++){
            sum[t] = sum[t-1]+sum[t-2];
        }
        return sum[n];
    }

    public static void main(String[] args) {
        int n =11;
        Solution s = new Solution();
        System.out.println(s.climbStairs(n));
    }
}
