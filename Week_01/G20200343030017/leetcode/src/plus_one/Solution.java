package plus_one;

import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        for (int n=digits.length-1;n>=0;n--){
            if (digits[n]==9){
                digits[n]=0;
            }else{
                digits[n]=digits[n]+1;
                return digits;
            }
        }
        int[] temp = new int[digits.length+1];
        System.arraycopy(digits,0,temp,1,digits.length);
        temp[0] = 1;
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = {9,9,9};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.plusOne(nums)));
    }
}
