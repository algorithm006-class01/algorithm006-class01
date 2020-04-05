package datast.string;

public class LeetCode_771_611 {

    class Solution {
        public int numJewelsInStones(String J, String S) {
            int sum= 0;
            for (char c : S.toCharArray()) {
                for (char c1 : J.toCharArray()) {
                    if (c == c1) sum++;
                }
            }
            return sum;
        }
    }
}
