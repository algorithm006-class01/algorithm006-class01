package G20200343030391;

public class LeetCode_231_391 {

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        boolean value = new LeetCode_231_391().isPowerOfTwo_2(n);
        System.out.println(value);
    }

    public boolean isPowerOfTwo_1(int n) {
        if (n == 0) return false;
        while (n % 2 == 0) n /= 2;
        return n == 1;
    }

    public boolean isPowerOfTwo_2(int n) {
        if (n == 0) return false;
        return ((long) n & (-(long) n)) == (long) n;
    }
}
