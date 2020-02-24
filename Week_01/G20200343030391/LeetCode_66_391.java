package G20200343030391;

import java.util.Arrays;

public class LeetCode_66_391 {

    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] plusOne = plusOne(nums);
        System.out.println(Arrays.toString(plusOne));

    }

    /**
     * 末位无进位，直接加一;
     * 末位有进位，则末位=0，下一位继续加一，直到！=0，结束进位，
     * 进位全为0，位数+1
     * 时间复杂度：O(n)
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[len + 1];

        digits[0] = 1;
        return digits;
    }
}
