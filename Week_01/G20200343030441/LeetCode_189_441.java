/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        // 暴力法，直接移动，复杂度为O(kn)
        // int last_element = nums[nums.length-1];

        // for (int i = 0; i < k; ++i){
        //     for (int j = nums.length-1; j > 0; --j){
        //         nums[j] = nums[j-1];
        //     }
        //     nums[0] = last_element;
        //     last_element = nums[nums.length-1];
        // }

        // 反转方法
        k %= nums.length;
        swap_array(nums, 0, nums.length-1);
        swap_array(nums, 0, k-1);
        swap_array(nums, k, nums.length-1);
    }

    private void swap_array(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
// @lc code=end

