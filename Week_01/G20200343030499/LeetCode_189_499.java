/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// 时间复杂度： O(n^2)
// 空间复杂度： O(1)
// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        while (k-- > 0) {
            moveToRightByOneStep(nums);
        }
    }

    private void moveToRightByOneStep(int[] nums) {
        int temp = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            nums[i + 1] = nums[i];
        }
        nums[0] = temp;
    }
}
// @lc code=end
