package G20200343030375;

public class LeetCode_191_375 {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n =n & (n-1);
            count++;
        }
        return count;
    }
    public boolean isPowerOfTwo(int n) {
        return (n>0) && (n&(n-1))==0;
    }
}
