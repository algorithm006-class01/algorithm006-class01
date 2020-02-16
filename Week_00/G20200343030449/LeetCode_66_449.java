/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// 时间复杂度： O(n)
// 空间复杂度： O(1)
// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        return plusOneAt(digits, digits.length - 1);
    }

    private int[] plusOneAt(int[] digits, int at) {
        if (at == -1) {
            int[] biggerDigits = new int[digits.length + 1];
            biggerDigits[0] = 1;
            return biggerDigits;
        }

        if (digits[at] == 9) {
            digits[at] = 0;
            return plusOneAt(digits, at - 1);
        } else {
            digits[at]++;
            return digits;
        }
    }
}
// @lc code=end
