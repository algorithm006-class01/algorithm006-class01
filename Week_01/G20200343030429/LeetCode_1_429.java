package leetcode.week01;

/**
 * @author Abner.S
 * @date 2020/2/16 14:47
 * @description No.26 remove-duplicates-from-sorted-array
 * 删除排序数组中的重复项
 */
public class LeetCode_26_429 {

    // 思路1：暴力解法 双重循环，发现不妥，可能需要额外的空间
    // 思路2：双指针，快慢指针
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[temp]) {
                temp++;
                nums[temp] = nums[i];
            }
        }
        return temp + 1;
    }

}
