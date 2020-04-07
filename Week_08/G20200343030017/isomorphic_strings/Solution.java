package week8.isomorphic_strings;

import java.util.HashMap;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        int x = 0;
        int y = 0;
        for (int n=0;n<s.length();n++){
            if (!map.containsKey(s.charAt(n))){
                map.put(s.charAt(n),'a'+x);
                x++;
            }
            if (!map2.containsKey(t.charAt(n))){
                map2.put(t.charAt(n),'a'+y);
                y++;
            }
        }
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for (int n=0;n<s.length();n++){
            sb.append(map.get(s.charAt(n)));
            sb2.append(map2.get(t.charAt(n)));
        }
        return sb.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {
        String s = "foo",t="bar";
        Solution p = new Solution();
        System.out.println(p.isIsomorphic(s,t));
    }
}
