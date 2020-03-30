public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int bitSize = 31; n !=0; n = n >>> 1,bitSize--){
            ans += (n & 1) << bitSize;
        }
        return ans;
    }
}