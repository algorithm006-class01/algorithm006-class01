package move_zeroes;

import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums) {
        for (int a=0;a<nums.length-1;a++){
            for (int b=a+1;b<nums.length;b++){
                if (nums[a]==0 && nums[b]!=0){
                    nums[a] = nums[b];
                    nums[b] = 0;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        Solution s = new Solution();
        s.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
