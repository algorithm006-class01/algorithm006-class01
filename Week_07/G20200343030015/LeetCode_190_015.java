package G20200343030015.week_07;

/**
 * Created by majiancheng on 2020/3/29.
 *
 * 190. 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 */
public class LeetCode_190_015 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (n & 1);
            n >>= 1;
        }

        return res;
    }
}
