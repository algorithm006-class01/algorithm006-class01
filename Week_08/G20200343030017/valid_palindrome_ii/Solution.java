package week8.valid_palindrome_ii;

public class Solution {

    public boolean validPalindrome(String s) {
        int begin = 0,end=s.length()-1;
        while(begin<end){
            if (s.charAt(begin)!=s.charAt(end)){
                return validProcess(begin,end-1,s)||validProcess(begin+1,end,s);
            }
            begin++;
            end--;
        }
        return true;
    }

    public boolean validProcess(int begin,int end,String s){
        char[] temps = s.toCharArray();
        while(begin<end){
            if (temps[begin]!=temps[end]){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String k = "eeccccbebaeeabebccceea";
        Solution s = new Solution();
        System.out.println(s.validPalindrome(k));
    }
}
