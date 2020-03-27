package recursion;

import java.util.ArrayList;
import java.util.List;

public class isAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chars2 = t.toCharArray();

        Arrays.sort(chars);
        Arrays.sort(chars2);

        return Arrays.equals(chars, chars2);
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int co : count) {
            if (co != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }


        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
            if (count[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
