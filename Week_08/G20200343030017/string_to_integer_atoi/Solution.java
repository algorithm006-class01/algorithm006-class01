package week8.string_to_integer_atoi;

public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length()==0) return 0;
        char first = str.charAt(0);
        if ((first<=47 || first>=58)){
            if (first==43 && str.length()!=1 && str.charAt(1)!=45){
                str = str.substring(1);
            }else{
                if(first!=45){
                    return 0;
                }
                if ((first==45 && str.length()==1) ||(first==45 && str.charAt(1)==43 )){
                    return 0;
                }
            }
        }
        boolean fu = false;
        if (first == 45){
            fu = true;
            str = str.substring(1);
        }
        for (int n=0;n<str.length();n++){
            if (str.charAt(n)<=47 || str.charAt(n)>=58){
                str = str.substring(0,n);
                if (str.length()==0) return 0;
                break;
            }
        }
        if (Double.valueOf(str)>Integer.MAX_VALUE){
            if (fu){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }
        char[] cs = str.toCharArray();
        int result = 0;
        int mi = 0;
        for (int n=0;n<cs.length;n++){
            if ((cs[cs.length-1-n]<=47 || cs[cs.length-1-n]>=58)){
                continue;
            }
            result = result + (cs[cs.length-1-n]-48)*(int)Math.pow(10,mi);
            mi++;
        }
        if (fu){
            return -1*result;
        }else{
            return result;
        }
    }

    public static void main(String[] args) {
        String str = "-abc";
        Solution s = new Solution();
        System.out.println(s.myAtoi(str));
    }
}
