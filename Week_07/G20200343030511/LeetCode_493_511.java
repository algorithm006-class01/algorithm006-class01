class Solution {
   int count = 0;

	public int reversePairs(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		mergerSort(0, nums.length - 1, nums);

		return count;
	}

	private void mergerSort(int l, int r, int[] nums) {
		if (l < r) {
			int mid = l + (r - l) / 2;
			mergerSort(l, mid, nums);
			mergerSort(mid + 1, r, nums);
			mergerToSort(l, mid, r, nums);
		}

	}

	// 7 3 8 6
	private void mergerToSort(int l, int mid, int r, int[] nums) {
		int[] tmp = new int[r - l + 1];
		int i = l, j = mid + 1, start = l, end = mid + 1;
		int k = 0;

		/*
		 * while (start <= mid && end <= r) { if (nums[start] / 2.0 > nums[end])
		 * { count += end - mid ; end++; } else { start++; } }
		 */
		while (start <= mid) {
			while (end <= r && nums[start] / 2.0 > nums[end]) {
				end++;
			}
			count += end - mid - 1;
			start++;
		}

		while (i <= mid && j <= r) {
			tmp[k++] = nums[i] > nums[j] ? nums[j++] : nums[i++];
		}
		while (i <= mid)
			tmp[k++] = nums[i++];
		while (j <= r)
			tmp[k++] = nums[j++];
		for (int k2 = 0; k2 < tmp.length; k2++) {
			nums[l++] = tmp[k2];
		}

	}
}