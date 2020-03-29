package datast.sort;

public class LeetCode_493_611 {
    class Solution {

        private int count;

        public int reversePairs(int[] nums) {
            merge_sort(nums, 0, nums.length - 1);
            return count;
        }

        private void merge_sort(int[] array, int left, int right) {
            if (left >= right) return;
            int mid = (left + right) / 2;
            merge_sort(array, left, mid);
            merge_sort(array, mid + 1, right);
            merge(array, left, mid, right);
        }

        private void merge(int[] array, int left, int mid, int right) {
            int[] temp = new int[right - left + 1];
            int i = left, t = left, k = 0;
            for (int j = mid + 1; j <= right; j++, k++) {
                while (i <= mid && array[i] <= array[j]) temp[k++] = array[i++];
                while (t <= mid && array[t] <= 2 * (long) array[j]) t++;
                count += mid - t + 1;
                temp[k] = array[j];
            }
            while (i <= mid) temp[k++] = array[i++];
            System.arraycopy(temp, 0, array, left, temp.length);
        }
    }
}
