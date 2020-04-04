package week8.reverse_words_in_a_string;

import java.util.Arrays;

public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] temps = s.split("\\s+");
        System.out.println(Arrays.toString(temps));
        int begin=0,end=temps.length-1;
        String temp = "";
        while (begin < end){
            temp = temps[begin];
            temps[begin] = temps[end];
            temps[end] = temp;
            begin++;
            end--;
        }
        return String.join(" ",temps);
    }

    public static void main(String[] args) {
        String st = "a good   example";
        Solution s = new Solution();
        System.out.println(s.reverseWords(st));
    }
}
