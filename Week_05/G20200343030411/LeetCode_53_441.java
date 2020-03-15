/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int[] states = new int[nums.length];

        states[0] = nums[0];

        for (int i = 1; i < nums.length; ++i){
            if (states[i-1] + nums[i] < nums[i]) states[i] = nums[i];
            else states[i] = states[i-1] + nums[i];
        }

        int res = states[0];
        for (int s : states) if (res < s) res = s;

        return res;
    }
}
// @lc code=end

