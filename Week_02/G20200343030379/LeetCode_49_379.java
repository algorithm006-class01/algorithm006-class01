package G20200343030379;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：有效的字母异位词
public class LeetCode_49_379 {
    public static void main(String[] args) {

    }
    class Solution {
        //哈希法-排序法
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String,List<String>> hash=new HashMap<String,List<String>>();
            for (int i = 0; i < strs.length; i++) {
                char[] s_arr = strs[i].toCharArray();
                Arrays.sort(s_arr);
                String key=String.valueOf(s_arr);
                if(hash.containsKey(key)){
                    hash.get(key).add(strs[i]);
                }else{
                    List<String> list=new ArrayList<>();
                    list.add(strs[i]);
                    hash.put(key,list);

                }
            }
            return new ArrayList<>(hash.values());
        }

        //哈希法-字符计数法
        public List<List<String>> groupAnagrams2(String[] strs) {
            Map<String,List<String>> hash=new HashMap<>();
            for (int i = 0; i < strs.length; i++) {

                int nums[]=new int[26];
                for (int j = 0; j < strs[i].length(); j++) {
                    nums[strs[i].charAt(j)-'a']++;
                }

                StringBuilder sb=new StringBuilder();

                //组成 0#2#
                for (int j = 0; j < nums.length; j++) {
                    sb.append(nums[j]).append('#');
                }

                String key=sb.toString();
                if(hash.containsKey(key)){
                    hash.get(key).add(strs[i]);
                }else{
                    List<String> temp=new ArrayList<>();
                    temp.add(strs[i]);
                    hash.put(key,temp);
                }
            }

            return new ArrayList<>(hash.values());
        }
    }
}
