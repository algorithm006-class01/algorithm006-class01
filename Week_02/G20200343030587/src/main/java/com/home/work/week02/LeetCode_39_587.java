package com.home.work.week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode_39_587 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            put(sort(strs[i]), strs[i], res);
        }
        return new ArrayList<List<String>>(res.values());
    }

    private void put(String s,String rs, HashMap<String, List<String>> map){
        List<String> list = map.get(s);
        if (list == null) {
            list = new ArrayList<>();
            map.put(s, list);
        }
        list.add(rs);
    }

    private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
