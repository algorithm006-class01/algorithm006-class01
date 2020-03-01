package Week_03;

public class Leetcode_055_001 {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }

        return lastPos == 0;
    }
}
