package week8.first_unique_character_in_a_string;

import java.util.HashMap;

public class Solution {
    public int firstUniqChar(String s) {
        if (s.length()==0) return -1;
        HashMap<Character,Integer> map = new HashMap();
        for (int n=0;n<s.length();n++){
            if (map.containsKey(s.charAt(n))){
                map.put(s.charAt(n),-1);
            }else{
                map.put(s.charAt(n),n);
            }
        }
        int n = 100000;
        for (Integer value:map.values()){
            if (value != -1){
                n = Math.min(n,value);
            }
        }
        if (n==100000){
            return -1;
        }else{
            return n;
        }
    }
}
