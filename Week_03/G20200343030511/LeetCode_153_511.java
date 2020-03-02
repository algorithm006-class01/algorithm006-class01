class Solution {
    public int findMin(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		int l = 0;
		int r = nums.length - 1;
		int mid;
		while (l < r) {
			mid = l + (r - l) / 2;
			if (nums[mid] >= nums[l] && nums[l] > nums[r])
				l = mid + 1;
			else {
				r = mid;
			}

		}
		return nums[l];
	}
}