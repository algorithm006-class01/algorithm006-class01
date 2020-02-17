/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 方案一，先把nums2中元素放在nums1的后端，再快速排序
        
        // 方案二，比较后把大的交换至nums2中，最后再合并
        // for (int i = 0; i < m; ++i){
        //     for (int j = 0; j < n; ++j){
        //         if (nums1[i] > nums2[j]){
        //             int temp = nums1[i];
        //             nums1[i] = nums2[j];
        //             nums2[j] = temp;
                    
        //             // 调整nums2[j]的位置
        //             for (int p = j; p < n-1; ++p){
        //                 if (nums2[p] > nums2[p+1]){
        //                     int temp2 = nums2[p];
        //                     nums2[p] = nums2[p+1];
        //                     nums2[p+1] = temp2;
        //                 }else{
        //                     break;
        //                 }
        //             }

        //             break;
        //         }
        //     }
        // }

        // for (int i = 0; i < n; ++i){
        //     nums1[m+i] = nums2[i];
        // }

        // 方案三，双指针，拷贝数组
        // Make a copy of nums1.
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n))
        nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        // if there are still elements to add
        if (p1 < m)
        System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
        System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }

    
}
// @lc code=end

