package datast.string;

public class LeetCode_58_611 {

    class Solution {
        public int lengthOfLastWord(String s) {
            if (s.length() == 0) return 0;
            int i = s.length() - 1;
            while (i >= 0 && s.charAt(i) == ' ') i--;
            for (int j = i; j >= 0 ; j--){
                if (s.charAt(j) == ' ') return i == s.length() - 1 ? s.length() - j - 1 : i - j;
            }
            return i == s.length() - 1 ? s.length() : i+ 1;
        }
    }
}
