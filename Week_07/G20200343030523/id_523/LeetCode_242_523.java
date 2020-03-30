package hashmap;

public class ValidAnagram01 {

    public boolean isAnagram(String s, String t) {

        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }

        for (int i : alphabet) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
//        String s = "rat", t = "cat";
//        String s = "aa", t = "a";
        ValidAnagram01 validAnagram = new ValidAnagram01();
        System.out.println(validAnagram.isAnagram(s, t));
    }

}
