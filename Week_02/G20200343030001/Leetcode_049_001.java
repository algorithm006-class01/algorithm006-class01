package Week_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode_049_001 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mapping = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            String temp = String.valueOf(chars);

            if (!mapping.containsKey(temp)) {
                mapping.put(temp, new ArrayList());
            }

            mapping.get(temp).add(s);
        }

        return new ArrayList(mapping.values());
    }
}
