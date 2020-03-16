/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        
        return Math.max(myRob(1,n-1,nums), myRob(0,n-2,nums));
    }

    private int myRob(int start, int end, int[] nums){
        int n = nums.length;
        int state_2 = nums[start];
        int state_1 = Math.max(nums[start], nums[start+1]);
        int state_i = 0;

        for (int i = 2; i < n-1; ++i){
            state_i = Math.max(state_1, state_2+nums[start+i]);
            state_2 = state_1;
            state_1 = state_i;
        }

        return Math.max(state_2, Math.max(state_1, state_i));
    }

    // 国内站高票方法
    // public int rob(int[] nums) {
    //     int n = nums.length;
    //     if (n == 1) return nums[0];
    //     return Math.max(robRange(nums, 0, n - 2), 
    //                     robRange(nums, 1, n - 1));
    // }
    
    // // 仅计算闭区间 [start,end] 的最优结果
    // int robRange(int[] nums, int start, int end) {
    //     int n = nums.length;
    //     int dp_i_1 = 0, dp_i_2 = 0;
    //     int dp_i = 0;
    //     for (int i = end; i >= start; i--) {
    //         dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
    //         dp_i_2 = dp_i_1;
    //         dp_i_1 = dp_i;
    //     }
    //     return dp_i;
    // }
    
}
// @lc code=end

