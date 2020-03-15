package datast.dp;

public class LeetCode_53_611 {

    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length == 1) return nums[0];
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i < nums.length; i ++){
                dp[i] = Math.max(dp[ i - 1], 0) + nums[i];
                max = Math.max(dp[i], max);
            }
            return max;
        }
    }
}
