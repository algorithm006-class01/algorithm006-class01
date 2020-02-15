package rotate_array;

import java.util.Arrays;

public class Solution {
    public void rotate(int[] nums, int k) {
        int temp = 0;
        for (int n=0;n<k;n++){
            temp = nums[nums.length-1];
            for (int a=1;a<nums.length;a++){
                nums[nums.length-a] = nums[nums.length-a-1];
            }
            nums[0] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,6,7};
        int k = 3;
        Solution s = new Solution();
        s.rotate(a,3);
        System.out.println(Arrays.toString(a));
    }
}
