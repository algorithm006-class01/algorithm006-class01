class Solution {
    //双指针解法
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int p = 0;
        for (int q = 1; q < nums.length; q++){
            if (nums[p] != nums[q]){
                if (q - p > 1){
                    nums[p + 1] = nums[q];
                }
                p++;
            }
        }
        return p+1;
    }
}