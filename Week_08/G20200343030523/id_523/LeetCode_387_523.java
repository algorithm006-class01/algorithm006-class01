package str;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

/**
 * @description: https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @author: alan
 * @date: 2020/4/5
 * @time: 6:09 下午
 */
public class FirstUniqueCharacterInAString01 {

    public int firstUniqChar(String s) {
        int[] ret = new int[26];
        for (Character c : s.toCharArray()) {
            ret[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (ret[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        FirstUniqueCharacterInAString01 inAString = new FirstUniqueCharacterInAString01();
        System.out.println(inAString.firstUniqChar(s));
    }

}
