class Solution {
    public int search(int[] nums, int target) {
        // 边界条件
        if (null == nums || nums.length == 0){
            return -1;
        }
        // 二分法左右边界
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            // 对比mid low high的值是否等于target
            if (nums[mid] == target){
                return mid;
            }
            if (nums[low] == target){
                return low;
            }
            if (nums[high] == target){
                return high;
            }
            // 找不到情况下移动左右边界
            if (nums[low] <= nums[mid]){
                if (target > nums[low] && target < nums[mid]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else {
                if (target < nums[high] && target > nums[mid]){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}