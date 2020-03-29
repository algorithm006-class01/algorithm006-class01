class Solution {
    private int ret = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return ret;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right + left) >> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }

    private void merge(int[] nums, int left, int right, int mid) {
         int[] temp = new int[right - left + 1];
         int i = mid + 1, j = i, k = 0;

         for (int q = left; q <= mid; q++) {
             while (j <= right && nums[q] > 2 * (long)nums[j]) j++;
             ret += j - (mid + 1);
             while (i <= right && nums[q] >= nums[i]) temp[k++] = nums[i++];
             temp[k++] = nums[q];
         }
        while (i <= right) temp[k++] = nums[i++];
        System.arraycopy(temp, 0, nums, left, temp.length);
    }
}