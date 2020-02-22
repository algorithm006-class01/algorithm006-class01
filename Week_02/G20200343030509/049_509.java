/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}

