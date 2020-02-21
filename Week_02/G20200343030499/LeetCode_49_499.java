/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
import java.util.*;
import java.math.BigInteger;

class Solution {
    // 1. use sorted strings as keys
    public List<List<String>> groupAnagrams_1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] strTemp = str.toCharArray();
            Arrays.sort(strTemp);
            String sortedStr = new String(strTemp);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<String>());
            }
            map.get(sortedStr).add(str);
        }
        return new ArrayList(map.values());
    }

    // 2. generate string from str:strs to get keys
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> grouper = new HashMap<>();
        for (String str : strs) {
            String strKey = getCharCounts(str);
            if (!grouper.containsKey(strKey)) {
                grouper.put(strKey, new ArrayList<String>());
            }
            grouper.get(strKey).add(str);
        }
        return new ArrayList(grouper.values());
    }

    private String getCharCounts(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 0);
            }
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            if (map.containsKey(c)) {
                sb.append(c);
                sb.append(map.get(c));
            }
        }
        return sb.toString();
    }

    // 3. use prime numbers to get keys.
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] primeNumbers = new String[] { "2", "3", "5", "7", "11", "13", "17", "19", "23", "29", "31", "37", "41",
                "43", "47", "53", "59", "61", "67", "71", "73", "79", "83", "89", "97", "101" };
        Map<BigInteger, List<String>> grouper = new HashMap<>();
        for (String str : strs) {
            BigInteger strInt = BigInteger.ONE;
            for (int i = 0; i < str.length(); i++) {
                strInt = strInt.multiply(new BigInteger(primeNumbers[str.charAt(i) - 'a']));
            }
            if (!grouper.containsKey(strInt)) {
                grouper.put(strInt, new ArrayList<String>());
            }
            grouper.get(strInt).add(str);
        }
        return new ArrayList(grouper.values());
    }
}
// @lc code=end
