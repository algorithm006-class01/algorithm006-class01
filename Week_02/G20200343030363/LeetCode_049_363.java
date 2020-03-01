package cn.geek.week2;

import java.util.*;

/**
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月18日 14:07:00
 */
public class LeetCode_049_363 {

    private final static int ENGLISH_LENGTH = 26;

    /**
     * Group anagrams list. 找出数组里面的异位词 暴力解法
     *
     * @param strs
     *            the strs
     * @return the list
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List> map = new HashMap<>();

        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);

            char[] charArr = str.toCharArray();
            for (char c : charArr) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ENGLISH_LENGTH; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        LeetCode_049_363 leetcode = new LeetCode_049_363();
        List<List<String>> result = leetcode.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> list : result) {
            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
