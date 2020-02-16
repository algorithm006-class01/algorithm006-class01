package G20200343030391;

import java.util.Arrays;

public class LeetCode_26_391 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates_1(nums);
        System.out.println(i + ":" + Arrays.toString(nums));
    }

    /**
     * 双指针:慢指针j保留去重后下标，快指针i寻找下一个数字
     * 时间复杂度：O(n)
     * @param nums
     * @return
     */
    public static int removeDuplicates_1(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }

}
