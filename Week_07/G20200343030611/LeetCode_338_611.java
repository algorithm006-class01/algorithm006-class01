package datast.bitwise;

public class LeetCode_338_611 {

    class Solution {
        public int[] countBits(int num) {
            int[] result = new int[num + 1];
            for (int i = 1; i <= num; i++){
                if ( (i & 1) == 1){
                    // 奇数
                    result[i] = result[i - 1] + 1;
                } else {
                    // 偶数
                    result[i] = result[i/2];
                }
            }
            return result;
        }
    }
}
