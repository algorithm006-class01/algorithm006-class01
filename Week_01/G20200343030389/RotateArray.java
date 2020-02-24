package follow.phenix.ice.algorithm.weekone;

import java.util.Arrays;

/**
 * @author iceiceice
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
    }

    private static void rotate(int[] nums, int k) {
        int rotateCount = 0;
        while (rotateCount < k) {
            int temp;
            int prev = nums[nums.length - 1];
            for (int i = 0; i < nums.length; i++) {
                temp = nums[i];
                nums[i] = prev;
                prev = temp;
            }
            rotateCount++;
        }
        System.out.println(Arrays.toString(nums));
    }
}
