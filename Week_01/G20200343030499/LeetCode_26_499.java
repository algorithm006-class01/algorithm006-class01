/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */
// 时间复杂度： O(n)
// 空间复杂度： O(1)
// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return length;
        }

        // 从位置1开始插入第一个和currentNum不相等的数字
        int result = 1;
        int insertPos = 1;
        int currentNum = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] != currentNum) {
                nums[insertPos] = nums[i];
                result++;
                insertPos++;
                currentNum = nums[i];
            }
        }

        // 剩余位置补0
        for (int i = result; i < length; i++) {
            nums[i] = 0;
        }
        return result;
    }
}
// @lc code=end
