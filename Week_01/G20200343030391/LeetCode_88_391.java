package G20200343030391;

import java.util.Arrays;

public class LeetCode_88_391 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 双指针：从尾部开始遍历，最大的放到最尾巴；最后补充num2未遍历到的
     * 时间复杂度 : O(n)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Tail = m - 1;
        int nums2Tail = n - 1;
        int mergeTail = m + n - 1;
        while (nums1Tail >= 0 && nums2Tail >= 0) {
            if (nums1[nums1Tail] < nums2[nums2Tail]) {
                nums1[mergeTail] = nums2[nums2Tail];
                mergeTail--;
                nums2Tail--;
            } else {
                nums1[mergeTail] = nums1[nums1Tail];
                mergeTail--;
                nums1Tail--;
            }
        }
        System.arraycopy(nums2, 0, nums1, 0, nums2Tail + 1);
    }
}
