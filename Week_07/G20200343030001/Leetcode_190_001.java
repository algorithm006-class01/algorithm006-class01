package Week_07;

public class Leetcode_190_001 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;

        for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
            ans += (n & 1) << bitsSize;
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 43261596, result = 964176192;

        System.out.println(4 >>> 1);
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(result));
        System.out.println(new Leetcode_190_001().reverseBits(43261596) == result);
    }
}
