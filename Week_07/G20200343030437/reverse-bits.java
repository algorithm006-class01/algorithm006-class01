public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int m=31; n!=0; m--) {
            result += (n&1) << m;
            n >>>= 1;
        }
        return result;
    }
}
