package week7.reverse_pairs;

public class Solution {
    public int reversePairs(int[] nums) {
        int n = 0;
        if (nums.length==0) return 0;
        long[] nums2 = new long[nums.length];
        for (int z=0;z<nums.length;z++){
            nums2[z]=nums[z];
        }
        return sort(nums2,0,nums2.length-1);
    }

    public int sort(long[] nums,int left,int right){
        if (right <=left) return 0;
        int mid = (left+right)/2;
        int n = sort(nums,left,mid)+sort(nums,mid+1,right);
        int j = mid+1;
        for (int i=left ; i <= mid; i++) {
            while (j <= right && ((nums[i] >> 1) + (nums[i] & 1)) > nums[j]) j++;
            n += (j - (mid + 1));
        }
        merge(nums,left,mid,right);
        return n;
    }

    public void merge(long[] nums,int left,int mid,int right){
        int i = left;
        int j = mid+1;
        int k = 0;
        long[] temp = new long[right - left + 1];
        while (i <= mid && j <= right) {
            temp[k++] = (nums[i] <= nums[j]) ? nums[i++] : nums[j++];
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        System.arraycopy(temp, 0, nums, left, k);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        Solution s = new Solution();
        System.out.println(s.reversePairs(nums));
    }
}
