package G20200343030391;


public class LeetCode_53_391 {

    public static void main(String[] args) {
        int[] nums = {1};
        int i = new LeetCode_53_391().maxSubArray_1(nums);
        System.out.println(i);
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray_1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        ans = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

}
