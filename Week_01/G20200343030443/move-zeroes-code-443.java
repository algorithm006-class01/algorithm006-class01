class Solution {
    public void moveZeroes(int[] nums) {
        int i, j;// i:全递增，j:非零递增
        for (i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        // i结束遍历后，从j开始后面全部赋值0
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
