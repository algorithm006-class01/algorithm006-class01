package week5.edit_distance;

public class Solution {
    //dp(i,j)=min(dp(i-1,j),dp(i,j-1),dp(i-1,j-1))+d

    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        if (l1==0) return  l2;
        if (l2==0) return  l1;

        int[][] dp = new int[l1+1][l2+1];
        // inital
        dp[0][0] = 0;
        for (int n=0;n<l1+1;n++){
            dp[n][0] = n;
        }
        for (int n=0;n<l2+1;n++){
            dp[0][n] = n;
        }
        int d;
        for (int n=1;n<l1+1;n++){
            for (int t=1;t<l2+1;t++){
                if (word1.charAt(n-1)==word2.charAt(t-1)){
                    d = 0;
                }else{
                    d = 1;
                }
                dp[n][t] = Math.min(Math.min(dp[n-1][t]+1,dp[n][t-1]+1),dp[n-1][t-1]+d);
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        String word1 = "zoologicoarchaeologist";
        String word2 = "zoogeologist";
        Solution s = new Solution();
        System.out.println(s.minDistance(word1,word2));
    }
}
