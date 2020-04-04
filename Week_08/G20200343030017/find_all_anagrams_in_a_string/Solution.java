package week8.find_all_anagrams_in_a_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        HashMap<Character,Integer> target = new HashMap<>();
        HashMap<Character,Integer> bj = new HashMap<>();
        for (int n=0;n<p.length();n++){
            if (target.containsKey(p.charAt(n))){
                int value = target.get(p.charAt(n));
                target.put(p.charAt(n),++value);
            }else{
                target.put(p.charAt(n),1);
            }
        }
        int left=0,right=0;
        int match = p.length();
        char[] cs = s.toCharArray();
        while(right<s.length()){
            if (target.containsKey(cs[right])){
                if (bj.containsKey(cs[right])){
                    int value = bj.get(cs[right]);
                    bj.put(cs[right],++value);
                }else{
                    bj.put(cs[right],1);
                }
                if (bj.get(cs[right])<=target.get(cs[right])){
                    match--;
                }
            }
            while(match == 0){
                if (right-left+1 == p.length()){
                    list.add(left);
                }
                char c = s.charAt(left);
                if (bj.containsKey(c)){
                    int value = bj.get(cs[left]);
                    bj.put(cs[left],--value);
                    if (bj.get(cs[left])<target.get(cs[left])){
                        match++;
                    }
                }
                left++;
            }
            right++;
        }
        return list;
    }

    public static void main(String[] args) {
        String s="cbaebabacd";
        String p="abc";
        Solution pp = new Solution();
        System.out.println(pp.findAnagrams(s,p).toString());
    }
}
