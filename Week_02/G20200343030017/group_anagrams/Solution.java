package week2.group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupAnagrams = new ArrayList<>();
        HashMap<Integer,List<String>> map = new HashMap<>();
        for (String temp:strs){
            Integer aaa = countWord(temp);
            if (map.isEmpty()||!map.containsKey(aaa)){
                List<String> list = new ArrayList<>();
                list.add(temp);
                map.put(aaa,list);
            }else{
                List<String> list = map.get(aaa);
                list.add(temp);
                map.put(aaa,list);
            }
        }
        System.out.println(map);
        for (int key:map.keySet()){
            groupAnagrams.add(map.get(key));
        }
        return groupAnagrams;
    }

    public Integer countWord(String word){
        char[] str = word.toCharArray();
        Arrays.sort(str);
        return String.valueOf(str).hashCode();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{
                "eat","tea","tan","ate","nat","bat"};
        Solution s = new Solution();
        System.out.println(s.groupAnagrams(strs).toString());
    }
}
