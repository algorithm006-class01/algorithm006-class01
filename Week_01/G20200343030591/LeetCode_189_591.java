/**
 * 题目名称：旋转数组
 */
class Solution {

    // 暴力法一轮旋转一次 旋转K轮
    public void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    // hash取模  1构建一个新数组；2用取模的方式把原数组中的元素定位到指定位置；3.最后把新数组中的元素复制给原数组
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            a[ (i + k) % len ] = nums[i];
        }
        for (int j = 0; j < len; j++) {
            nums[j] = a[j];
        }
    }
}



