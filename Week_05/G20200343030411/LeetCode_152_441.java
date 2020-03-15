/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子序列
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int[] states = new int[nums.length]; // 记录最大
        int[] states_minus = new int[nums.length]; // 记录最小

        states[0] = nums[0];
        states_minus[0] = nums[0];

        for (int i = 1; i < nums.length; ++i){
            states[i] = Math.max(nums[i], Math.max(nums[i]*states[i-1], nums[i]*states_minus[i-1]));
            states_minus[i] = Math.min(nums[i], Math.min(nums[i]*states[i-1], nums[i]*states_minus[i-1]));
        }

        int res = states[0];
        for (int s : states) if (res < s) res = s;

        return res;
    }
}
// @lc code=end

