package datast.sort;

import java.util.Arrays;

public class LeetCode_242_611 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;
            char[] charArray1 = s.toCharArray();
            char[] charArray2 = t.toCharArray();
            Arrays.sort(charArray1);
            Arrays.sort(charArray2);
            return Arrays.equals(charArray1, charArray2);
        }
    }
}
