package com.leetcode.practices;

import java.util.*;

/**
 * leetcode.49.字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class Solution {

//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> map = new HashMap<>();
//        for (String str: strs) {
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            String key = String.valueOf(chars);
//            if (map.containsKey(key)) {
//                map.get(key).add(str);
//            } else {
//                List<String> list = new ArrayList<>();
//                list.add(str);
//                map.put(key, list);
//            }
//        }
//        return new ArrayList<>(map.values());
//    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            String key = generateKey(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }

        }
        return new ArrayList<>(map.values());
    }

    /**
     * 将输入的str进行编码。
     * 编码方法：先建立一个大小为26的数组，字母a-z分别对应数组0-25位置，
     * 然后按字母出现次数进行累加，并更新字母对应数组位置的值。
     * 最后返回字符数组int->String
     * @param str
     * @return
     */
    public String generateKey(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[(byte)c - 97] += 1;
        }
        StringBuilder sb = new StringBuilder();

        return Arrays.toString(count);
    }
    
}
