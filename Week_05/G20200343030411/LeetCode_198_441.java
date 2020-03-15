import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int[] states = new int[nums.length];

        if (nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];
        
        if (nums.length == 2)return Math.max(nums[0], nums[1]);
            
        if (nums.length == 3) return Math.max(nums[2] + nums[0], nums[1]);
        
        states[0] = nums[0];
        states[1] = nums[1];
        states[2] = nums[2] + nums[0];

        for (int i = 3; i < nums.length; ++i){
            states[i] = Math.max(states[i-2], states[i-3]) + nums[i];
        }

        return Math.max(states[nums.length-1], states[nums.length-2]);
    }
}
// @lc code=end

