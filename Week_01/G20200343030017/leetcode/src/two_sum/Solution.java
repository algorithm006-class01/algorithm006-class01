package two_sum;

import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];
        for (int a=0;a<nums.length-1;a++){
            for (int b=a+1;b<nums.length;b++){
                if (nums[a]+nums[b]==target){
                    temp[0]=a;
                    temp[1]=b;
                    return temp;
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.twoSum(nums,target)));
    }
}
