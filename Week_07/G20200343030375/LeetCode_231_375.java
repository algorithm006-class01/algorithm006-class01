package G20200343030375;

public class LeetCode_231_375 {
    public boolean isPowerOfTwo(int n) {
        return (n>0) && (n&(n-1))==0;
    }
}
