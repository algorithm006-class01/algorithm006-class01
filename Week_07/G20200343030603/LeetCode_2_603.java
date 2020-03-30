class Solution {
    public boolean isPowerOfTwo(int n) {
        // // 方法一：
        // if (n == 0) return false;
        // long x = (long) n;
        // return (x & (-x)) == x;

        //方法二：
        if (n == 0) return false;
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }
}