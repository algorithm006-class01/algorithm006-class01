package G20200343030391;

public class LeetCode_213_391 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int rob = new LeetCode_213_391().rob_1(nums);
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
        if (nums.length == 1) {
            return nums[0];
        }
        int[][] dp = new int[nums.length][2];
        dp[0][1] = nums[0];
        dp[0][0] = 0;
        dp[1][1] = nums[0];
        dp[1][0] = nums[1];


        int max = Math.max(dp[1][0], dp[1][1]);

        for (int i = 2; i < nums.length; i++) {
            if(i < nums.length -1){
                dp[i][0] = Math.max(dp[i-1][0], dp[i-2][0] + nums[i]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-2][1] + nums[i]);
            }else{
                //如果第一个房间没有被偷，那么最后一个房间就是个正常的房间。
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + nums[i]);
                //如果第一个房间被偷了，那么最后一个房间就不能偷了，此时我们只有一个选择，就是不偷，只能等于dp[i-1];
                dp[i][1] = dp[i - 1][0];

            }
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));

        }
        return max;
    }
}
