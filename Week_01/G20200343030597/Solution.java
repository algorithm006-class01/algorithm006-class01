package Week_01.G20200343030597;

public class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i-- ) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            System.out.println(digits[i]);
            if(digits[i] != 0){
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
    public void moveZeroes(int[] nums) {
        int j = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

}
