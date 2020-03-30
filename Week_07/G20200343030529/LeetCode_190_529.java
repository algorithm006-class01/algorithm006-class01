public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        // for (int i = 1; i <= 32; i++) {
        //     ret = ret | (n & 1);
        //     if (i != 32) {
        //         ret = ret << 1;
        //         n = n >>> 1; //无符号右移
        //     }
        // }

        for (int i = 31; n != 0; i--) {
            ret += (n & 1) << i;
            n = n >>> 1;
        }
        return ret;
    }

}