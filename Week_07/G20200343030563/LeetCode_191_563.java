public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //把mask左移，而不是不断的把n右移，因为右移对于负数前面加的是1
        int count = 0;
        int mask = 0x1;
        for (int i = 0; i < 64; i++){
            if ((n & mask) != 0) count++;
            mask <<= 1;
        }

        return count;  
    }
}