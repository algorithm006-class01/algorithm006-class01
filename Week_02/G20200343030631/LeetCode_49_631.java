package com.dsx.forty.nine;

import java.util.*;

/**
 * 解题思路: 遍历数组元素，对每个元素转为字符数组后排序，排序后放入结果map中，已存在的则取出结果map的value，放入value的list中
 * 时间复杂度: O(nklogk), n是 strs的长度，k是strs中字符串的最大长度
 * 空间复杂度: O(nk)
 * 执行用时 :9 ms, 在所有 Java 提交中击败了99.61%的用户
 * 内存消耗 :45.2 MB, 在所有 Java 提交中击败了9.66%的用户
 * @Author: loe881@163.com
 * @Date: 2020/2/21
 */
public class Version1 {

    public static void main(String[] args) {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strings));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (null == strs || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] tmpChars = str.toCharArray();
            Arrays.sort(tmpChars);
            String tmpStr = String.valueOf(tmpChars);
            if (!result.containsKey(tmpStr)) {
                result.put(tmpStr, new ArrayList<>());
            }
            result.get(tmpStr).add(str);
        }
        return new ArrayList<>(result.values());
    }
}

package com.dsx.forty.nine;

import java.util.*;

/**
 * 解题思路: 用数组存储字符串中每个字符出现的次数，最后拼接数组为统计字符串如#1#1，代表ab各出现1次
 *  对比字符串形成的统计字符串是否相等
 * 时间复杂度: O(nk)
 * 空间复杂度: O(nk)
 * 执行用时: 41 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :45.2 MB, 在所有 Java 提交中击败了9.66%的用户
 * @Author: loe881@163.com
 * @Date: 2020/2/21
 */
public class Version2 {
    public static void main(String[] args) {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strings));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (null == strs || strs.length == 0){
            return new ArrayList<>();
        }

        Map<String, List<String>> result = new HashMap<>();
        int[] counts = new int[26];
        for (String str : strs) {
            Arrays.fill(counts, -1);
            char[] tmpChars = str.toCharArray();
            for (char tmpChar : tmpChars) {
                counts[tmpChar - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                stringBuilder.append("#");
                stringBuilder.append(counts[i]);
            }
            String key = stringBuilder.toString();
            if (!result.containsKey(key)){
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(str);
        }
        return new ArrayList<>(result.values());
    }
}
