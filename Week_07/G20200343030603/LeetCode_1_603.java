//1.for loop: 0 --> 32
//2.%2,/2
//3.&1,x = x >>1;(32)
//4.while(x > 0) {count++;x = x&(x-1);}

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // //方法一：循环和位移动
        // int bits = 0;
        // int mask = 1;
        // for (int i = 0; i < 32; i++) {
        //     if ((n & mask) != 0) {
        //         bits++;
        //     }
        //     mask <<= 1;
        // }
        // return bits;

        //方法二：x & (x-1) 清零最低位
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n -1); // n = n & (n - 1);
        }
        return sum;
    }
}