package bitwise;

/**
 * https://leetcode-cn.com/problems/reverse-bits/
 * Created by bluzelee on 2020/3/29.
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 31; n != 0 && i >= 0; i--) {
            ret += (n & 1) << i;
            n = n >>> 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits(43261596));
    }
}
