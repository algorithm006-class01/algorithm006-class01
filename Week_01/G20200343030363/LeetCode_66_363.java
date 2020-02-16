package cn.geet.week1;

/**
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月16日 10:16:00
 */
public class LeetCode_66_363 {

    /**
     * Plus one int [ ]. 重点在进位
     *
     * @param digits
     *            the digits
     * @return the int [ ]
     */
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;

            // 没有进位就直接返回
            if (digits[i] != 0) {
                return digits;
            }
        }

        // 有进位
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
