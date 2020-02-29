class Solution {
    public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int l = 0;
		int r = nums.length - 1;
		int mid;
		while (l < r) {
			mid = l + (r - l) / 2;
			//ĞèÒªÅĞ¶ÏµÈºÅ
			if (target > nums[mid] && nums[mid] >= nums[l]) {
				l = mid + 1;
			} else if (target > nums[mid] && target < nums[l]) {
				l = mid + 1;
			} else if (target < nums[l] && nums[l] <= nums[mid]) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return l == r && nums[l] == target ? l : -1;
	}
}