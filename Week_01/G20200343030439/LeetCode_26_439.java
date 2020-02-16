/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项 
 */

// @lc code=start
class Solution12 {
    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 2, 2 };
        int result = removeDuplicates2(nums);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}
// @lc code=end
