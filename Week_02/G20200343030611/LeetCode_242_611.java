package datast.hashtable;

public class LeetCode_242_611 {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        for (int i = 0; i < sCharArray.length; i++) {
            counter[sCharArray[i] - 'a']++;
            counter[tCharArray[i] - 'a']--;
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) return false;
        }
        return true;
    }
}
