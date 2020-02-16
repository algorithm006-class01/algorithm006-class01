class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length <= 0) {
            return digits;
        }
        digits[digits.length -1] ++;
        for (int index = digits.length - 1; index >= 0 && digits[index] > 9; index --) {
            digits[index] -= 10;
            if (index == 0) {
                int[] newArr = new int[digits.length + 1];
                System.arraycopy(digits, 0, newArr, 1, digits.length);
                newArr[0] = 1;
                digits = newArr;
                break;
            }
            digits[index - 1] ++;
        }
        return digits;
    }
}