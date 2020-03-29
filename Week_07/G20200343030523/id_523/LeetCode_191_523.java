package bitwise;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 * Created by bluzelee on 2020/3/29.
 */
public class NumberOf1Bits02 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits02 bits02 = new NumberOf1Bits02();
        System.out.println(bits02.hammingWeight(11));
    }

}
