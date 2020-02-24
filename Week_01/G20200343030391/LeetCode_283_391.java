package G20200343030391;

import java.util.Arrays;

public class LeetCode_283_391 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1};
        moveZeroesDoubleCursor(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 暴力补0
     *  index记录非0下标，若有0则直接向前移动；最后补0
     *  时间复杂度O(n)
     * @param nums
     */
    public static void moveZeroes_1(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 双指针：
     *  快指针i 满指针j 非0元素直接前移
     *  时间复杂度O(n)
     * @param nums
     */
    public static void moveZeroesDoubleCursor(int[] nums) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
    }

}
