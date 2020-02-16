package array;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int j = m - 1;
        int i = n - 1;
        int pos = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums2[i] >= nums1[j]) {
                nums1[pos--] = nums2[i--];
            } else {
                nums1[pos--] = nums1[j];
                nums1[j] = Integer.MIN_VALUE;
                j--;
            }
        }

        while (i >= 0) {
            nums1[i] = nums2[i];
            i--;
        }

    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] num2 = new int[]{-1, 1, 2};
        int n = 3;

        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(num1, m, num2, n);
    }

}
