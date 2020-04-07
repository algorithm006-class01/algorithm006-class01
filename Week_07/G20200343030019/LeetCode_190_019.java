public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int out = 0;
        int index = 32;
        while (index-- != 0) {
            out = out << 1;
            if ((n & 1) == 1) {
                out++;
            }
            n = n >> 1;
        }
        return out;
    }
}