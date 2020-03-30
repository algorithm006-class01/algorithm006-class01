package leetcode.Week07;

public class LeetCode_191_535 {

    /**
     * method1: 都是获取最低位，然后再移位，循环32次
     */
    public int hammingWeight1(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((1 & n) != 0){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    /**
     * method2:有多少的1，就循环多少次
     */
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }

}
