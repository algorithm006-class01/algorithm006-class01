package week8.reverse_words_in_a_string_iii;

public class Solution {
    public String reverseWords(String s) {
        String[] temps = s.split(" ");
        for (int n=0;n<temps.length;n++){
            temps[n] = operate(0,temps[n].length()-1,temps[n]);
        }
        return String.join(" ",temps);
    }

    public String operate(int begin,int end,String temps){
        char[] temp = temps.toCharArray();
        char c;
        while (begin < end){
            c = temp[end];
            temp[end] = temp[begin];
            temp[begin] = c;
            begin++;
            end--;
        }
        return new String(temp);
    }
}
