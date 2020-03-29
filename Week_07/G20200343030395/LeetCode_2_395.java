package Week_07.G20200343030395;

public class LeetCode_2_395 {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n & (n-1)) ==0;
    }
}
