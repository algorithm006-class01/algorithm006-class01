class Solution {

    // 双指针法
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int pos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[pos] != nums[i]) {
                nums[++pos] = nums[i];
            }
        }
        return pos + 1;
    }
}