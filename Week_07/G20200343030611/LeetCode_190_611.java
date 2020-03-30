package datast.bitwise;

public class LeetCode_190_611 {

    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int result = 0;
            for (int bitSize = 31; n != 0; n = n >>> 1, bitSize--) {
                result += (n & 1) << bitSize;
            }
            return result;
        }
    }
}
