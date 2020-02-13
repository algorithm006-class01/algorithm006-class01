package G20200343030391;

import java.util.Arrays;

public class LeetCode_26_391 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates_1(nums);
        System.out.println(i + ":" + Arrays.toString(nums));
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public static int removeDuplicates_1(int[] nums) {
        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[j]) {
                nums[]
            }
        }
        return j;
    }

    /**
     * 递归
     * @param nums
     * @return
     */
    public static int removeDuplicates_2(int[] nums) {
        return 0;
    }
}
