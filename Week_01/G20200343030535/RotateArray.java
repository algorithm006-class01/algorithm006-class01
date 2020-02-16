package leetcode;

public class RotateArray {


    /***
     * 题目：
     *  https://leetcode-cn.com/problems/rotate-array/
     */

    public static void rotate1(int[] nums, int k) {
        while (k > 0){
            int temp = nums[nums.length - 1];
            System.arraycopy(nums,0,nums,1,nums.length - 1);
            nums[0] = temp;
            k--;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int[] A = {1,2,3,4,5,6,7};
        rotate1(A,k);
    }

}
