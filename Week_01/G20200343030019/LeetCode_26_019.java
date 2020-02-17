class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        if (nums.length ==1) {
            return 1;
        }
        int repeatNum = 0;
        for (int index = 1; index < nums.length; index ++) {
            if (nums[index] == nums[index -1]) {
                repeatNum ++;
            } else {
                nums[index - repeatNum] = nums[index];
            }
        }
        return nums.length - repeatNum;
    }
}