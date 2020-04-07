package G20200343030391;

public class LeetCode_191_391 {

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        int i = new LeetCode_191_391().hammingWeight_2(n);
        System.out.println(i);
    }

    public int hammingWeight_1(int n) {
        int result = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                result++;
            }
            mask = mask << 1;
        }
        return result;
    }

    public int hammingWeight_2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
