class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;
        int middle = 0;
        while (lo < hi) {
            middle = lo + (hi - lo) / 2;
            if (nums[0] <= target ^ target <= nums[middle] ^ nums[middle] < nums[0]) {
                lo = middle + 1;
            } else {
                hi = middle;
            }
        }

        return nums[lo] == target? lo: -1;

    }
}