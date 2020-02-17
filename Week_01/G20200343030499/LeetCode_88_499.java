/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */
// 时间复杂度： O(m+n)
// 空间复杂度： O(1)
// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m != 0 && n != 0) {
            nums1[m + n - 1] = nums1[m - 1] > nums2[n - 1] ? nums1[m-- - 1] : nums2[n-- - 1];
            merge(nums1, m, nums2, n);
        }
        if (m == 0 && n != 0) {
            nums1[n - 1] = nums2[n - 1];
            merge(nums1, 0, nums2, n - 1);
        }
    }
}
// @lc code=end
