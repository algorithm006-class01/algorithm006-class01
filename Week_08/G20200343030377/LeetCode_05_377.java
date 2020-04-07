class Solution {
     //暴力
     //动态规划
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len<2) return s;
        boolean[][] dp = new boolean[len][len];
        for(int i=0; i<len; i++){
            dp[i][i] = true;
        }

        int start = 0;
        int maxLen = 1;
        for(int j=1; j<len; j++){
            for(int i=0; i<j; i++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i<3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else{
                    dp[i][j] = false;
                }
                if(dp[i][j]){
                    int curLen = j-i+1;
                    if(curLen>maxLen){
                        start = i;
                        maxLen = curLen;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
