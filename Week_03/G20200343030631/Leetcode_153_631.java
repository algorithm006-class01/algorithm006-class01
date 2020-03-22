class Solution {
    public int findMin(int[] nums) {
        // 边界条件
        if (null == nums || nums.length == 0){
            throw new UnsupportedOperationException("arrays does not contains element");
        }
        int low = 0;
        int high = nums.length - 1;
        // 特殊边界条件
        if (nums[high] >= nums[low]){
            return nums[0];
        }
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }
            if (nums[mid] < nums[mid - 1]){
                return nums[mid];
            }
            if (nums[mid] > nums[low]){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }
}