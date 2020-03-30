package leetcode.Week07;

public class LeetCode_190_535 {

    public static int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++){
            result = result + (n & 1); /**获取最低位并且和转换过的加*/
            n = n >>> 1; /**将n进行右移一位*/
            if(i < 31){
                result = result << 1; /**将result左移1位*/
            }
        }
        

        return result;
    }

    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(reverseBits(n));
    }

}
