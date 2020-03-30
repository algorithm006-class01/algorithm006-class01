package Week_07;

public class Leetcode_242_001 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] index = new int[26];

        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            index[t.charAt(i) - 'a']--;

            if (index[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
