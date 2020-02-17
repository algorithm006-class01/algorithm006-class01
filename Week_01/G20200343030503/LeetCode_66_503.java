/**
 * 
 * homework
 * https://leetcode-cn.com/problems/plus-one/
 * 
 * 题目理解: 其实就是多位数加1之后的值 特殊情况就是出现9的时候需要进位,如果999这种数字,加1之后需要进位,需要给数组扩容
 * time complexity O(n) 
 * space complexity O(1)
 * 
 * 
 */
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0 ; i--) {
            digits[i]++;
            digits[i] = digits[i]%10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}