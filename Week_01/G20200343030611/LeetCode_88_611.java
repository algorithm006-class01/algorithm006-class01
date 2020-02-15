package datast.array;

public class LeetCode_88_611 {

    /**
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1;
        int q = n - 1;
        int f = m + n - 1;
        while ((p >= 0) && (q >= 0)) {
            nums1[f--] = nums1[p] > nums2[q] ? nums1[p--] : nums2[q--];
        }
        System.arraycopy(nums2, 0, nums1, 0, q + 1);
    }
}
