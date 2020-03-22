package G20200343030391;

public class LeetCode_198_391 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        int rob = new LeetCode_198_391().rob_2(nums);
        System.out.println(rob);

    }

    /**
     * 动态规划 二维数组状态空间
     * @param nums
     * @return
     */
    public int rob_1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    /**
     * 动态规划 一维数组状态空间
     * @param nums
     * @return
     */
    public int rob_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int res = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
