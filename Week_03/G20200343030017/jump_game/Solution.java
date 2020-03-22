package week3.jump_game;

public class Solution {

    public boolean canJump(int[] nums) {
        if (nums.length<=1) return true;
        if (nums[0] == 0) return false;
        for (int n=0;n<nums.length-1;n++){
            if (nums[n]==0){
                for (int k=n-1;k>=0;k--){
                    if (nums[k]+k>n){
                        break;
                    }
                    if (k==0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums={2,0,0};
        Solution s = new Solution();
        System.out.println(s.canJump(nums));
    }
}
