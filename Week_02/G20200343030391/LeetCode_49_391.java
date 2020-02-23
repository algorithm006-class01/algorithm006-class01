package G20200343030391;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_49_391 {

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strings);
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = Arrays.toString(charArray);
            ArrayList<String> list = map.putIfAbsent(key, new ArrayList<String>() {{
                add(str);
            }});
            if (list != null) {
                list.add(str);
            }
        }
        List<List<String>> resultList = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            resultList.add(entry.getValue());
        }
        return resultList;
    }

}
