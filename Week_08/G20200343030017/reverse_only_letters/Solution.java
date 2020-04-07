package week8.reverse_only_letters;

public class Solution {
    public String reverseOnlyLetters(String S) {
        char[] temps = S.toCharArray();
        int begin = 0;
        int end = temps.length-1;
        char c;
        while (begin < end){
            System.out.println(Integer.valueOf(temps[begin])+":"+Integer.valueOf(temps[end]));
            if ((temps[begin]<65 || temps[begin]>122) || (temps[begin]>90 && temps[begin]<97)){
                begin++;
                continue;
            }
            if ((temps[end]<65 || temps[end]>122) || (temps[end]>90 && temps[end]<97)){
                end--;
                continue;
            }
            c = temps[end];
            temps[end] = temps[begin];
            temps[begin] = c;
            begin++;
            end--;
        }
        return new String(temps);
    }


    public static void main(String[] args) {
        //String st = "a-bC-dEf-ghIj";
        String st = "Czyr^";
        Solution s = new Solution();
        System.out.println(s.reverseOnlyLetters(st));
    }
}
