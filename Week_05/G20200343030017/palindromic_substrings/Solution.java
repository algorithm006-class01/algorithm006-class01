package week5.palindromic_substrings;


public class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int n=0;n<s.length();n++){
            int left = n;
            int right =n+1;
            while(left>=0&&right<s.length()){
                if (s.charAt(left)==s.charAt(right)){
                    count++;
                    left--;
                    right++;
                }else{
                    break;
                }
            }
            left = n;
            right =n;
            while(left>=0&&right<s.length()){
                if (s.charAt(left)==s.charAt(right)){
                    count++;
                    left--;
                    right++;
                }else{
                    break;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        String word = "aaa";
        Solution s = new Solution();
        System.out.println(s.countSubstrings(word));
    }
    // a 0 b 1 c 2 d 3 e
    // 0   1   2   3   4
}
