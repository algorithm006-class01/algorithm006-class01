/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (58.54%)
 * Likes:    496
 * Dislikes: 0
 * Total Accepted:    107K
 * Total Submissions: 180.4K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
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

