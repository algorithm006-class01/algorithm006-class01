class Solution {
    public boolean canJump(int[] nums) {
        int n = 1;
        for (int i = nums.length-2 ; i >= 0; i--) {
            if (nums[i] >= n) {
                n = 1;
            } else {
                n++;
            }
            if(i == 0 && nums[0] < n) return false;
        }
        return true;
    }
