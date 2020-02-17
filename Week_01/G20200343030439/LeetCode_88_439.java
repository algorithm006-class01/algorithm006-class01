import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组 
 */

// @lc code=start
class Solution {
   // 使用类库方法
   public static void merge(int[] nums1, int m, int[] nums2, int n) {
    System.arraycopy(nums2, 0, nums1, m, n);
    Arrays.sort(nums1);
}

// 双指针 / 从前往后
public static void merge2(int[] nums1, int m, int[] nums2, int n) {
    int[] nums1_copy = new int[m];
    System.arraycopy(nums1, 0, nums1_copy, 0, m);
    int p1 = 0;
    int p2 = 0;

    int p = 0;

    while (p1 < m && p2 < n) {
        nums1[p++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++];
    }

    if (p1 < m) {
        System.arraycopy(nums1_copy, p1, nums1, p, m - p1);
    } else if (p2 < n) {
        System.arraycopy(nums2, p2, nums1, p, n - p2);
    }
}

// 方法三 : 双指针 / 从后往前
public static void merge3(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1;
    int p2 = n - 1;

    int p = m + n - 1;
    while (p1 >= 0 && p2 >= 0) {
        nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
    }
    if (p2 >= 0){
        for (int i = 0; i <= p2; i++){
            nums1[i] = nums2[i];
        }
    }
}
}
// @lc code=end

