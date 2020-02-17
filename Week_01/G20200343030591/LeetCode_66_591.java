class Solution {
    /**
     * 加1
     * 思路解析：
     * 1、通过从后往前的循环，给个位数+1
     * 2、加1后，分两种情况：
     * 3、不需要进位直接返回就可以了
     * 4、需要进位 则进入下一轮循环，继续给前一位+1
     * 5、边界 如果循环都遍历完了 还是没有返回结果 那么说明数组的最高位也需要进位
     *      此时需要 扩容数组1位 然后给最高位补1
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            // 判断是否有进位 不为0 则无需进位，为0则需要进位
            digits[i] = digits[i] % 10;
            if (digits[i]!=0) return digits;
        }
        digits = new int[len+1];
        digits[0] = 1;
        return digits;
    }
}