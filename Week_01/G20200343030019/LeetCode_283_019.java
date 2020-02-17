class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        for (int index = 0; index < nums.length; index ++) {
            if(nums[index] != 0) {
                if (index == zeroIndex) {
                    zeroIndex ++;
                    continue;
                }
                nums[zeroIndex ++] = nums[index];
                nums[index] = 0;
            }
        }
    }
}