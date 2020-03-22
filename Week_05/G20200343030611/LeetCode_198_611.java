package datast.dp;

public class LeetCode_198_611 {

    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) return 0;
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            int max = dp[1];
            for (int i = 2; i < nums.length; i++){
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
                max = Math.max(dp[i], max);
            }
            return max;
        }
    }
}
