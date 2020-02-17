/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        for(var i = digits.length - 1; i >= 0; i--) {
            
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] ++;
                return digits;
            }
                            
        }
        int[] ret = new int[digits.length + 1];
        for (var i = 0; i < ret.length; i++) {
            ret[i] = 0;
        }
        ret[0] = 1;
        return ret;
    }
}
// @lc code=end

