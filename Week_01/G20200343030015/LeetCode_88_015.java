package G20200343030015.week_01;

import java.util.Arrays;

/**
 * Created by majiancheng on 2020/2/16.
 */
public class LeetCode_88_015 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copy_nums1 = Arrays.copyOf(nums1, m);

        int p = 0;
        int p1 = 0;
        int p2 = 0;
        while (p1 < copy_nums1.length && p2 < nums2.length) {
            nums1[p++] = (copy_nums1[p1] < nums2[p2]) ? copy_nums1[p1++] : nums2[p2++];
        }

        while (p1 < copy_nums1.length) {
            nums1[p++] = copy_nums1[p1++];
        }

        while (p2 < nums2.length) {
            nums1[p++] = nums2[p2++];
        }

    }
}

/**
 * 88. 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
