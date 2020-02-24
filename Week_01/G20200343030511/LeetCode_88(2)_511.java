class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      if (nums1.length < nums2.length)
			return ;
		int[] nums3 = new int[m];
		System.arraycopy(nums1, 0, nums3, 0, m);

		int i = 0, j = 0, k = 0;
		while (i < m && j < n) {
			if (nums3[i] < nums2[j]) {
				nums1[k++] = nums3[i];
				i++;
			} else {
				nums1[k++] = nums2[j];
				j++;
			}
		}
		// ºÏ²¢
		if (i < m) {
			System.arraycopy(nums3, i, nums1, k, m - i);
		}
		if (j < n) {
			System.arraycopy(nums2, j, nums1, k, n - j);
		}
    }
}