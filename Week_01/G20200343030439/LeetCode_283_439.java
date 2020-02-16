/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零 
 */

// @lc code=start
class Solution {
   
    public static void moveZeroes(int[] nums) {
        int zeroeCount = 0;
        int[] tempNums = new int[nums.length];
        int tempIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroeCount++;
            } else {
                tempNums[tempIndex] = nums[i];
                tempIndex++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - zeroeCount) {
                nums[i] = tempNums[i];
            }
            else{
                nums[i]=0;
            }
        }
    }

    // 快慢指针
    public static void moveZeroes2(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[i];
                nums[i] = temp;
                slow++;

            }
        }
    }
}
// @lc code=end

