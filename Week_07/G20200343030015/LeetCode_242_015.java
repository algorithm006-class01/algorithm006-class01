package G20200343030015.week_07;

/**
 * Created by majiancheng on 2020/3/29.
 *
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 */
public class LeetCode_242_015 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] nums = new int[26];

        char[] chars = s.toCharArray();
        for(char c : chars) {
            nums[c - 'a'] ++;
        }
        chars = t.toCharArray();
        for(char c : chars) {
            nums[c - 'a'] --;
            if(nums[c - 'a'] < 0) return false;
        }

        return true;
    }
}
