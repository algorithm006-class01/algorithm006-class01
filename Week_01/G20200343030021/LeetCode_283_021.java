package week_01;/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public int[] moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
        return nums;
    }

    public int[] moveZeroes2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }else if (count > 0) {
                nums[i - count] = nums[i];
                nums[i] = 0;
            }
        }
        return nums;
    }

    public int[]  moveZeroes_3(int[] nums) {
        int count = 0;
        for (int i = 0; i <nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                nums[i - count] = nums[i];
                nums[i] = 0;
            }
        }
        return nums;
    }
}
// @lc code=end