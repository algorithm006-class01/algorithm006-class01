package week7.valid_anagram;

import java.util.Arrays;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {return false;}
        int [] ss = new int[27];
        int [] tt = new int[27];
        for (int n=0;n<s.length();n++){
            ss[(int)s.charAt(n)-96]++;
        }
        for (int n=0;n<t.length();n++){
            tt[(int)t.charAt(n)-96]++;
        }
        if (Arrays.equals(ss,tt)){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "a", t = "ab";
        Solution solution = new Solution();
        System.out.println(solution.isAnagram(s,t));
    }
}
