package week8.reverse_string_ii;

public class Solution {
    public String reverseStr(String s, int k) {
        if (s.length()<2) return s;
        char[] cs = s.toCharArray();
        int n = 0;
        while(n<=s.length()){
            int begin = n;
            int end = Math.min(2*k+n,s.length());
            if (end+1-begin>2*k){
                operate(begin,begin+k-1,cs);
                n = end;
            }else if(end-begin<k){
                operate(begin,s.length()-1,cs);
                break;
            }else{
                operate(begin,begin+k-1,cs);
                break;
            }
        }
        return String.valueOf(cs);
    }

    public void operate(int begin,int end,char[] temp){
        char c;
        while (begin < end){
            c = temp[end];
            temp[end] = temp[begin];
            temp[begin] = c;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        String c = "abcdefg";
        Solution s = new Solution();
        System.out.println(s.reverseStr(c,3));
    }
}
