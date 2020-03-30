package week7.power_of_two;

public class Solution {
    public boolean isPowerOfTwo(int n) {
        int a = n&(n-1);
        return n>0 && (a==0);
    }
}
