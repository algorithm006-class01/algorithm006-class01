package array;

/**
 * https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne01 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }

        if (digits[0] == 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9, 9, 9};
        PlusOne01 plusOne = new PlusOne01();
        int[] res = plusOne.plusOne(digits);
    }

}
