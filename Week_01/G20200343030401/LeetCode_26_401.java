//题目链接: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

class Solution {
    //方法1: 双指针法 时间复杂度O(n) 空间复杂度O(1) 
    public int removeDuplicates1(int[] nums) {
        if(nums == null || nums.length == 0){
          return 0;
        }
        int i = 0;
        for(int j = 1; j < nums.length; j++ ){
            if(nums[i] != nums[j])
            i++;
            nums[i] = nums[j];     
        }
        return i + 1;
    }

    //方法2: 双指针法优化 时间复杂度O(n) 空间复杂度O(1)
    public int removeDuplicates2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                //当 q - p > 1 时，才进行复制
                if(q - p > 1){
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }
}
