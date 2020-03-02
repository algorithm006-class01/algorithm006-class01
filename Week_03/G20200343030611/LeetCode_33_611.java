package datast.binary_search;

public class LeetCode_33_611 {

    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        // 求出最小值所在的索引（最小值也是反转点）
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (target >= nums[left] && target <= nums[nums.length - 1]) {
            right = nums.length - 1;
        } else {
            right = left - 1;
            left = 0;
        }
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
