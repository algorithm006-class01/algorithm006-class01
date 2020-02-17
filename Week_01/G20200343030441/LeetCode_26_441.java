/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;

        int current_num = nums[0];
        int current_index = 1;

        for (int i = 0; i < nums.length; ++i){
            if (nums[i] != current_num){
                current_num = nums[i];
                nums[current_index] = nums[i];
                current_index++;
            }
        }

        return current_index;
    }
}
// @lc code=end

