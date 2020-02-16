package leetcode;

import java.util.Arrays;

public class LeetCode_88_535 {

    /***
     * 题目：
     * https://leetcode-cn.com/problems/merge-sorted-array/
     */

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        /**合并之后并排序*/
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /**双指针法/从尾到头*/
        /**nums1和nums2的尾指针*/
        int p1 = m - 1;
        int p2 = n - 1;
        /**p指针用于追踪添加元素的位置*/
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0){
            /**后--：先赋值，再--*/
            nums1[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }
        /**p2 < 0退出循环是正常的，说明m > n。如果p1 < 0 退出循环,说明m < n,则对漏掉的数据进行处理**/
        System.arraycopy(nums2,0,nums1,0, p2 + 1);
    }


    public static void main(String[] args) {
        int[] A = {1,2,3,0,0,0,0,0,0};
        int[] B = {1,1,2,2,4,6};
        merge(A,3,B,6);
    }


}
