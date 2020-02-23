package cn.geek.week2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 字母异位词
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月18日 11:07:00
 */
public class LeetCode_242_363 {

    /**
     * Is anagram boolean. 忽略大小写
     *
     * @param source
     *            the source
     * @param target
     *            the target
     * @return the boolean
     */
    public boolean isAnagram(String source, String target) {

        // 暴力解法 O(n)
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            char temp = source.charAt(i);
            int count = map.get(temp) == null ? 0 : map.get(temp);
            map.put(temp, ++count);
        }

        for (int j = 0; j < target.length(); j++) {
            char temp = target.charAt(j);
            int count = map.get(temp) == null ? 0 : map.get(temp);
            map.put(temp, --count);
        }

        for (Integer count : map.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Is anagram by sort boolean.  暴力解法直接用java原生api
     *
     * @param source
     *            the source
     * @param target
     *            the target
     * @return the boolean
     */
    public boolean isAnagramBySort(String source, String target) {
        char[] sourceArr = source.toCharArray();
        char[] targetArr = target.toCharArray();
        Arrays.sort(sourceArr);
        Arrays.sort(targetArr);
        return sourceArr.equals(targetArr);
    }

    /**
     * Is anagram by hash boolean.使用hash表
     *
     * @param source
     *            the source
     * @param target
     *            the target
     * @return the boolean
     */
    public boolean isAnagramByHash(String source, String target) {
        if (source.length() != target.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < source.length(); i++) {

            // char的加减是ascii码的加减
            table[source.charAt(i) - 'a']++;
            table[target.charAt(i) - 'a']--;
        }
        for (int count : table) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_242_363 leetcode = new LeetCode_242_363();
        System.out.println(leetcode.isAnagram("aaa", "aaa"));
        System.out.println(leetcode.isAnagramBySort("aaa", "aaa"));
    }
}
