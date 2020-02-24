package G20200343030391;

public class LeetCode_242_391 {

    public static void main(String[] args) {
        String s = "anaagram";
        String t = "nagaaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int[] hash = new int[26];
        for (int i = 0; i < sChar.length; i++) {
            hash[sChar[i] - 97]++;
            hash[tChar[i] - 97]--;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
