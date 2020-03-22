public class Solution {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 解题思路: 直接合并数组，合并后排序，缺陷是浪费了有序的条件
     * 时间复杂度: O((n+m)log(n+m))
     * 空间复杂度: O(1)
     * 执行用时: 1 ms, 在所有 Java 提交中击败了30.75%的用户
     * 内存消耗: 38.3 MB, 在所有 Java 提交中击败了5.02%的用户
     * @Author: loe881@163.com
     * @Date: 2020/3/2
     */
    public static void mergeV1(int[] nums1, int m, int[] nums2, int n) {
        // 合并nums2至nums1中
        System.arraycopy(nums2, 0, nums1, m, n);
        // 排序数组
        Arrays.sort(nums1);
    }

    /**
     * 解题思路: 利用有序条件+nums1空间足够条件，双指针从两个数组末端比较
     * 时间复杂度: O(n+m)
     * 空间复杂度: O(1)
     * 执行用时: 0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗: 38.3 MB, 在所有 Java 提交中击败了5.20%的用户
     * @Author: loe881@163.com
     * @Date: 2020/3/2
     */
    public static void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        // nums1数组元素位置
        int nums1Pos = m - 1;
        // nums2数组元素位置
        int nums2Pos = n - 1;
        // 合并后数组元素位置
        int numsPos = m + n - 1;
        while (nums1Pos >= 0 && nums2Pos >= 0){
            // 如果nums1当前位置元素大于nums当前位置元素，则取nums1当前位置元素放在合并数组中，同时nums1数组元素位置减一
            nums1[numsPos--] = (nums1[nums1Pos] > nums2[nums2Pos]) ? nums1[nums1Pos--] : nums2[nums2Pos--];
        }
        // 处理nums1的首个值大于nums2内值得情况
        System.arraycopy(nums2, 0, nums1, 0, nums2Pos + 1);
    }
}