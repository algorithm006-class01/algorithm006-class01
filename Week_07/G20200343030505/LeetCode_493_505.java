
class LeetCode_493_505 {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int s, int e){
        if(s>=e) return 0; 

        int mid = s + (e-s)/2; 
        
        //求出子数组翻转对数目
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); 

        //计算当前两个子数组之前的翻转对数目
        for(int i = s, j = mid+1; i<=mid; i++){
            while(j<=e && nums[i]/2.0 > nums[j]) j++; 
            cnt += j-(mid+1); 
        }


        //调用库函数排序
        Arrays.sort(nums, s, e+1); 
        return cnt; 
    }
}