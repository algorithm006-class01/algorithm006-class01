package Week_01.G20200343030395;

public class LeetCode_7_395 {


    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1;i>=0;i--) {
            //9的时候，进位，继续循环
            if(digits[i] == 9) {
                digits[i] = 0;
            } else {
                //不是0，直接加，返回
                digits[i] ++;
                return digits;
            }
        }

        digits = new int[digits.length +1];
        digits[0] = 1;
        return digits;
    }
}
