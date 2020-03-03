/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        // 遍历一遍法
        // int count = 1;
        // int current_num = nums[0];

        // for (int i = 1; i < nums.length; ++i){
        //     if (nums[i] == current_num){
        //         count++;
        //     }else {
        //         if (count == 0){
        //             count = 1;
        //             current_num = nums[i];
        //         }else {
        //             count--;
        //         }
        //     }
        // }
        // return current_num;

        // 分治法
        return _find(nums, 0, nums.length-1);
    }

    private int _find(int[] nums, int index_left, int index_right){
        if (index_left == index_right) return nums[index_left];


        int left = _find(nums, index_left, (index_right-index_left)/2 + index_left);
        int right = _find(nums, (index_right-index_left)/2 + index_left + 1, index_right);

        if (left == right) return left;

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, index_left, index_right);
        int rightCount = countInRange(nums, right, index_left, index_right);
        
        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

