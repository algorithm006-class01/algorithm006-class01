package Week_01;

import java.util.Arrays;

public class Leetcode_283_001 {
    public void moveZeroes(int[] nums) {
        int j = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[j] = nums[i];

                if (i != j) {
                    nums[i] = 0;
                }

                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 1, 100, 3, 12};

        System.out.println(Arrays.toString(arr));

        new Leetcode_283_001().moveZeroes(arr);

        System.out.println(Arrays.toString(arr));
    }
}
