class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int left, int right){
        if(left>=right) return 0;
        int mid = left + (right-left)/2;
        int cnt = mergeSort(nums, left, mid) + mergeSort(nums, mid+1, right);

        for(int i=left, j=mid+1; i<=mid; i++){
            while(j<=right && nums[i]/2.0 > nums[j]) j++;
            cnt += j-(mid+1);
        }

        merge(nums, left, mid, right);
        return cnt;
    }
    private void merge(int[] nums, int left, int mid,int right){
        int[] temp = new int[right-left+1];
        int i = left, j=mid+1, k=0;
        while(i<=mid && j<=right){
            temp[k++] = nums[i]<=nums[j]? nums[i++]:nums[j++];
        }
        while(i<=mid) temp[k++] = nums[i++];
        while(j<=right) temp[k++] = nums[j++];
        for(int p=0; p<temp.length; p++){
            nums[left+p] = temp[p];
        }
    }
}
