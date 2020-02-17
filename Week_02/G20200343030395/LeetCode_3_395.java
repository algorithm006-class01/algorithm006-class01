package Week_02.G20200343030395;

import java.util.*;

public class LeetCode_3_395 {

    public static void main(String[] args) {

        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        if(strs.length == 0) {
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) {
            return new ArrayList<List<String>>();
        }

        Map<String, List> map = new HashMap<String, List>();
        //循环
        for (String s : strs) {
            char[] ca = s.toCharArray();
            //排序
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            //分组
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }

            map.get(key).add(s);
        }

        //直接返回
        return new ArrayList(map.values());
    }
}
