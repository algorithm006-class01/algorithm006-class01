public class LeetCode_231_423 {
}

class Solution231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        long t = n;
        if ((t & (-t)) == t) {
            return true;
        }
        return false;
    }
}