class Solution {

    /**
     * 定义 left right双指针 以及 step步长 step = 2 * k
     * 遍历索引i直接用 left，  每次 遍历 给right 选择一个最小的值  看看 是否到了 数组的末尾
     *
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int left = 0, step = 2 * k; left < arr.length; left += step) {
            int right = Math.min(arr.length - 1, left + k - 1);
            swap(arr, left, right);
        }
        return new String(arr);
    }

    /**
     * 翻转字符串
     * @param arr
     * @param left
     * @param right
     */
    private void swap(char[] arr, int left, int right) {
        while (left < right) {

//            char tmp = a[left];
//            a[left++] = a[right];
//            a[right--] = tmp;

            arr[left] ^= arr[right];
            arr[right] ^= arr[left];
            arr[left++] ^= arr[right--];
        }
    }

}