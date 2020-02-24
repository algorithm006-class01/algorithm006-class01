/**
 * 
 * homework
 * https://leetcode-cn.com/problems/merge-sorted-array/ 
 *
 * 方式一、直接将数组二中的元素添加到数组一中然后排序 
 * time complexity O(nlogn) Arrays.sort(arr) 内部用的是快排时间复杂度是nlogn > 大于for循环的时间复杂度n所以取大的nlog
 * space complexity O(1)
 *
 * 方式二、将输出数组中的有效值存放到复制数组中nums1_copy, 分别定义2个指针到nums1_copy p1和nums2 p2  然后循环判断p1和p2所对应的值,将其添加到输出数组中
 * time complexity O(n + m)
 * space complexity O(m)  使用了一个复制数组,所以空间复杂度为O(m)
 *  方式二特别注意一点: 假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 如果没有这个条件那么会出现数组ArrayIndexOutOfBoundsException
 * 
 * 方式三、
 *  核心思想，从后往前将nums2和nums1中有效值中大的一次放到nums1的最后 
 *  实现: 定义三个指针分别从指向nums有效数值处p1，nums1的last处p，nums2的last处p2 
 * time complexity O(n + m)
 * space complexity O(1)  在原数组上进行的操作
 *
 *
 * 一定要注意: 题干明确表示需要  1. 有序整数数组  2. nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素
 *
 */
 
时间复杂度O(n) 是不是只要是一层循环,就可以理解为时间复杂度就是O(n)
class Solution1 {

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
         int j = 0;
         for (int i = m; i < m + n; i++) {
             nums1[i] = nums2[j];
             j++; 
         }
         Arrays.sort(nums1);
    }
    
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        //复制nums1的数组,保留有效数据位
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1,0,nums1_copy,0,m);
        //定义2个指针p1 0~m p2 0~n
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while (p1 < m && p2 < n) {
            if (nums1_copy[p1] < nums2[p2]) {
                nums1[p++] = nums1_copy[p1++];
            }else {
                nums1[p++] = nums2[p2++];
            }
        }
        if (p1 < m) {
            System.arraycopy(nums1_copy,p1,nums1,p1+p2,m+n-p1-p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2,p2,nums1,p1+p2,m+n-p1-p2);
        }
    }
    /**
     *  核心思想，因为题干明确 nums1 有足够的空间来保存 nums2 中的元素
     *  所以从nums1的last处开始存储nums1有效值与nums2中的最大值
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        //定义三个指针分别从指向nums有效数值处p1，nums1的last处p，nums2的last处p2
        //通常来说，下表总是从0开始，所以需要减1
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2>=0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            }else {
                nums1[p--] = nums2[p2--];
            }
        }
        //因为是在原数组nums1上进行操作，所以如果循环之后，nums1有多出来的不需要动，nums2多出来的需要放到nums1中
        System.arraycopy(nums2,0,nums1,0,p2+1);
    }

}


