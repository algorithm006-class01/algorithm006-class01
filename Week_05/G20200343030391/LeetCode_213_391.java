package G20200343030391;

public class LeetCode_213_391 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int rob = new LeetCode_213_391().rob_2(nums);
        System.out.println(rob);

    }

    /**
     * 动态规划
     * 二维数组状态空间 dp[i][j]  i代表对应房间，j代表是否偷0房间
     * 状态转移方式:
     *          1. i房间之前
     *              i.  不偷0： dp[i][0] = max(dp[i-1][0],dp[i-2][0]+nums[i])
     *              ii. 偷0 ： dp[i][1] = max(dp[i-1][1],dp[i-2][1]+nums[i])
     *          2. i房间：
     *              i.  不偷0,i可以正常取： dp[i][0] = max(dp[i-1][0],dp[i-2][0]+nums[i])
     *              ii. 偷0，i房间不能取 ： dp[i][1] = dp[i-1][1]
     * @param nums
     * @return
     */
    public int rob_1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[][] dp = new int[nums.length][2];
        //
        dp[0][1] = nums[0];
        dp[0][0] = 0;
        dp[1][1] = nums[0];
        dp[1][0] = nums[1];

        int max = Math.max(dp[1][0], dp[1][1]);

        for (int i = 2; i < nums.length; i++) {
            if (i < nums.length - 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + nums[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1] + nums[i]);
            } else {
                //如果第一个房间没有被偷，那么最后一个房间就是个正常的房间。
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + nums[i]);
                //如果第一个房间被偷了，那么最后一个房间就不能偷了，此时我们只有一个选择，就是不偷，只能等于dp[i-1][1];
                dp[i][1] = dp[i - 1][1];

            }
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));

        }
        return max;
    }
    /**
     * 动态规划：是否偷0房间拆分为两个数组取最大值
     * 一维数组状态空间 dp[i]
     * 状态转移方程：dp[i]=max(dp[i-1],dp[i-2]+nums[i])
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
        return Math.max(help(0, nums.length - 2, nums), help(1, nums.length - 1, nums));
    }

    private int help(int start, int end, int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        int max = Math.max(dp[0], dp[1]);
        for (int i = 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
