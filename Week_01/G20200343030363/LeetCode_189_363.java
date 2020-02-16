package cn.geet.week1;

/**
 *
 * 旋转数组
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月14日 16:43:00
 */
public class LeetCode_189_363 {

    /**
     * Rotate.
     *
     * @param nums
     *            the nums
     * @param k
     *            the k
     */
    public void rotate(int[] nums, int k) {

        // 三种解决方式 要求使用空间复杂度为 O(1) 的原地算法

        // 1、暴力解法

        // 2、使用额外数组 时间O(n) 空间O(n)
        // int[] tempArr = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        // tempArr[(i + k) % nums.length] = nums[i];
        // }
        //
        // for (int i = 0; i < nums.length; i++) {
        // nums[i] = tempArr[i];
        // }

        // 3、使用环状数组


        // 4、使用反转
         k = k % nums.length;
         reverse(nums, 0, nums.length - 1);
         reverse(nums, 0, k - 1);
         reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        LeetCode_189_363 temp = new LeetCode_189_363();
        temp.rotate(new int[] {1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
