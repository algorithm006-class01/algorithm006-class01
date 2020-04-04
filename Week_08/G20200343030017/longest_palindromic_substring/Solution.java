package week8.longest_palindromic_substring;

public class Solution {
    // dp[b,e]=dp[b+1,e-1]+dp[b]+dp[e]
    public String longestPalindrome(String s) {
        if (s.length()<2) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int n=0;n<s.length();n++){
            dp[n][n]=true;
        }
        int begin=0;
        int target = 1;
        for (int y=1;y<s.length();y++){
            for (int x=0;x<y;x++){
                if (s.charAt(x)==s.charAt(y)){
                    if (y-x<3){
                        dp[x][y]=true;
                    }else{
                        dp[x][y]=dp[x+1][y-1];
                    }
                }else{
                    dp[x][y]=false;
                }
                if (dp[x][y]){
                    int temp = y-x+1;
                    if (temp>target){
                        target = temp;
                        begin = x;
                    }
                }
            }
        }
        return s.substring(begin,begin+target);
    }

    public static void main(String[] args) {
        String word = "babad";
        Solution s = new Solution();
        System.out.println(s.longestPalindrome(word));
    }
}
