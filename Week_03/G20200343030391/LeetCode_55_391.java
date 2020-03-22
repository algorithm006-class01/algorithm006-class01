package G20200343030391;

import java.util.List;

public class LeetCode_55_391 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        boolean b = new LeetCode_55_391().canJump(nums);
        System.out.println(b);
    }

    public boolean canJump(int[] nums) {
        int canJump = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= canJump) {
                canJump = i;
            }
        }
        return canJump == 0;
    }
}
