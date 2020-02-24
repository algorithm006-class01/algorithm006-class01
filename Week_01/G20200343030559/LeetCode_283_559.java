package jc.demo;

public class LeetCode_283_559 {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
            else if (count > 0) {
                nums[i - count] = nums[i];
                nums[i] = 0;
            }

        }
    }
}
