class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int end = nums.length - 1;
        for (int index = nums.length - 1; index >= 0; index --) {
            if (nums[index] + index >= end) {
                end = index;
            }
        }
        return end == 0;
    }
}