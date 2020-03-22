/**
 *  乘积最大子序列
 *  
 *
 *
 */
class Solution {
    public int maxProduct(int[] nums) {
        int size = nums.length;
        if (size == 0) 
            return 0;
        else if (size == 1)
            return nums[0];
        int p = nums[0];
        int maxP = nums[0];
        int minP = nums[0];
        for (int i = 1; i < size; i++) {
            int temp = maxP;
            maxP = Math.max(Math.max(maxP*nums[i],nums[i]),minP*nums[i]);
            minP = Math.min(Math.min(temp*nums[i],nums[i]),minP*nums[i]);
            p = Math.max(maxP,p);
        }
        return p;
    }
}