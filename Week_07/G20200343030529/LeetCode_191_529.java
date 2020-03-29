public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //不能使用移位操作，因为n可能是负数，负数高位全是1，右移相当于高度补1
        //只能使用x = x & (x - 1)清零最低位的1
        int count = 0;
        
        while (n != 0) {
            count ++;
            n = n & (n - 1);
        }
        return count;
    }
}