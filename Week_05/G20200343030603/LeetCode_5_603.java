//DP方程：dp[i][j] = dp[i+1][j-1] && str[i]==str[j]
class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int res = 0;
        int size = s.length();
        boolean dp[][] = new boolean[size][size];
        for (int j = 0; j < size; j++) {
            for (int i = j; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j) && ((j - i < 2) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}