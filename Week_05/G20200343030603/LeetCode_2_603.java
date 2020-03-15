//动态规划：
// DP方程：一个字母可能是由一位数也可能是两位数
//if nums[i] + nums[i - 1] <= 26
//   dp[i] = dp[i - 1] + dp[i - 2] 
//else
//   dp[i] = dp[i - 1] 

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
    
        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            dp[i + 1] = s.charAt(i) == '0' ? 0 : dp[i];
            if (i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}