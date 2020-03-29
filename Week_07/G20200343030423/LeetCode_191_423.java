public class LeetCode_191_423 {
}

class Solution191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum ++;
            n = n & (n-1);
        }
        return sum;
    }
}