package week8.race_car;

public class Solution {
    //dp[target][speed]=dp[target-speed/2][speed/2]
    // aaatraget = 2^k-1
    // aaatarget == target ===> dp[target]=k
    // aaatarget > target ===> dp[target]=k+1+dp[aaatarget-target]
    // aaatarget < target ===> dp[target]=k+2+n+dp[target-2^n-1]
    public int racecar(int target) {
        int[] dp = new int[target+1];
        dp[0]=0;
        for (int n=1;n<=target;n++){
            int a =1;
            int aaaTarget = 1;
            while (aaaTarget<n){
                int lasta = 0;
                while ((1<<lasta)-1<aaaTarget){
                    dp[n] = Math.min(dp[n],a+2+lasta+dp[(n-(aaaTarget-((1<<lasta)-1)))]);
                    lasta++;
                }
                a++;
                aaaTarget = (1<<lasta)-1;
            }

            if (n == aaaTarget){
                dp[n] = a;
            }else{
                dp[n] = Math.min(dp[n],a+1+dp[aaaTarget-n]);
            }

        }
        return dp[target];
    }
}
