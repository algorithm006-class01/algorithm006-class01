/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {
        int len = nums.length + 2;
        int[] _nums = new int[len];
        System.arraycopy(nums, 0, _nums, 1, len - 2);
        _nums[0] = 1;
        _nums[len - 1] = 1;
        int[][] dp = new int[len][len]; // 1st dem means left, 2nd dem meas right
        for (int i = len - 2; i >= 0; i --) {
            for (int j = i + 2; j < len; j ++) {
                int maxBetweenIAndJ = 0;
                for (int k = i + 1; k <= j - 1; k ++) {
                    int lastShootK = dp[i][k] + dp[k][j] + _nums[i] * _nums[k] * _nums[j];
                    maxBetweenIAndJ = Math.max(maxBetweenIAndJ, lastShootK);
                }
                dp[i][j] = maxBetweenIAndJ;
            }
        }
        return dp[0][len - 1];
    }
}
// @lc code=end

