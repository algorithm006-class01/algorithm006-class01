class Solution {
    public int[] plusOne(int[] digits) {
        if (digits[0] == 0)
            return new int[] { 1 };
        if (++digits[digits.length - 1] < 10)
            return digits;
        for (int i = digits.length - 1; i >= 1 && digits[i] >= 10; i--) {
            digits[i] -= 10;
            digits[i - 1]++;
        }
        if (digits[0] < 10)
            return digits;
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
