class Solution {

    /**
     * 合并两个有序数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        //从后往前遍历
        while (len1 >=0 && len2 >= 0){
            //谁大就放到nums1的末尾
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        //遍历完nums1,把nums2剩余的数拷贝到nums1前面
        System.arraycopy(nums2,0,nums1,0,len2 + 1);
    }
}