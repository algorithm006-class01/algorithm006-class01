package week8.longest_increasing_subsequence;

public class Solution {
    //dp[n]=max(dp[j])+1
    public int lengthOfLIS(int[] nums) {
        if (nums.length==0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int len = 1;
        for (int n=1;n<nums.length;n++){
            int lastdp = 0;
            for (int k=0;k<n;k++){
                if (nums[n]>nums[k]){
                    lastdp = Math.max(lastdp,dp[k]);
                }
            }
            dp[n] = lastdp + 1;
            len = Math.max(len,dp[n]);
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        Solution s = new Solution();
        System.out.println(s.lengthOfLIS(nums));
    }
}
