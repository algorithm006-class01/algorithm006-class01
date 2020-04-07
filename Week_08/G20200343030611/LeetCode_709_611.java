package datast.string;

public class LeetCode_709_611 {
    class Solution {
        public String toLowerCase(String str) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] < 91 && chars[i] > 64) chars[i] = (char) (chars[i] + 32);
            }
            return String.valueOf(chars);
        }
    }
}
