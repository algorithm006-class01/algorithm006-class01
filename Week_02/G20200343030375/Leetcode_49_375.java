package G20200343030375;

import java.util.*;

/**
 * 执行用时 : 7 ms , 在所有 Java 提交中击败了 99.98% 的用户
 * 内存消耗 : 44.6 MB , 在所有 Java 提交中击败了 28.73% 的用户
 */
public class Leetcode_49_375 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>() ;
        Map<String,List<String>>  map = new HashMap<>();
        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
           String key = String.valueOf(c);
            List<String> childList = map.get(key);
            if(childList == null){
                childList = new ArrayList<>();
                childList.add(str);
                map.put(key,childList);
                result.add(childList);
            }else{
                childList.add(str);
            }
        }

        return result;
    }

    public static void main(String[] args){
        String [] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        Leetcode_49_375 lc = new Leetcode_49_375();
        lc.groupAnagrams(arr);
    }
}
