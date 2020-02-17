/**
 * 
 */

/**
 * @author huangwen05
 *
 * @date:   2020年2月16日 下午8:50:14 
 */
public class LeetCode_66_G20200343030505 {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) {
            return new int[0];
        }

        int i = digits.length - 1;     
        while (i >= 0) {
            digits[i] = digits[i] + 1;
            digits[i] = digits[i] % 10;
            if(digits[i] != 0) {
                return digits;
            }  
            --i;          
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;     
    }
}