package cn.geek.week7;

/**
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月27日 21:18:00
 */
public class LeetCode_242_363 {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for (char ch: s.toCharArray()) {
            count[ch-'a']++;
        }
        for (char ch: t.toCharArray()) {
            count[ch-'a']--;
        }
        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
