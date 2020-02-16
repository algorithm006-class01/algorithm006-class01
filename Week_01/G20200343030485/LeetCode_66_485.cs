public class Solution {
    public int[] PlusOne(int[] digits) {
        for (int i = digits.Length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] == 10) {
                digits[i] = 0;
            }
            else {
                return digits;
            }
        }

        digits = new int[digits.Length + 1];
        digits[0] = 1;

        return digits;
    }
}