class Solution {
    /*
        998
        999
        899
        119
        111
        Observing these numbers, we will find only 9 + 1 will carry to next digits
        and become 0

        1. so if any digit pluses one and doesnt carry, it's answer
        2. or keep doing next digit
        3. if loop all for loop, it means it's a all 9 digits number, add one more leading digit one in the index 0 of result

        time complexity: O(n), space complexity: O(n) ans's size
    */
    public int[] plusOne(int[] digits) {

        int len = digits.length;
        for (int i = len - 1; i >= 0 ; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int result[] = new int[len+1];
        result[0] = 1;

        return result;
    }
}