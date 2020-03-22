/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
// 因为它如果能从i跳到j，就能跳到i到j之间任意一个，因此从后贪心是最优的
class Solution {
    public boolean canJump(int[] nums) {
        int end = nums.length - 1;
        for (int i = nums.length - 1; i >= 0 ;i --) {
            if (nums[i] + i >= end) end = i;
        }
        return end == 0;
    }
}
// @lc code=end

