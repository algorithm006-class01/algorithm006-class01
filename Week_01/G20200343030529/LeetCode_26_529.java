import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    /*
    * 方法一、双指针（快慢指针），新建一个同样大小的数组，找出不一样的数值，填入新数组，最后用新数组的值代替愿数组
    */
    // public int removeDuplicates(int[] nums) {
    //     int[] temp = new int[nums.length];
    //     int size = 0;
    //     for (int i = 1, j = 0; i < nums.length; i++) {
    //         if (nums[j] != nums[i]) {
    //             temp[size++] = nums[j];
    //             temp[size++] = nums[i];
    //             j = i;
    //         }
    //     }
    //     for (int i = 0; i < size; i++) {
    //         nums[i] = temp[i];
    //     }
    //     return size;
    // }

    /*
    * 方法二、双指针（快慢指针），直接在原数组修改
    */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < nums.length;i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.removeDuplicates(new int[]{1,1,2});
    }
}
// @lc code=end

