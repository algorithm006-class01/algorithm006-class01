class Solution {
    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int lo = 0;
        int hi = nums.length - 1;
        int mi = 0;
        while (lo < hi) {
            mi = lo + (hi - lo) / 2;
            if (nums[0] > nums[mi]) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        return nums[lo];
    }
}