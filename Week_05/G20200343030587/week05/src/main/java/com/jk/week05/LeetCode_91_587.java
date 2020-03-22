package com.jk.week05;

public class LeetCode_91_587 {
    public int numDecodings(String s) {

        if (s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            //后两位组合 在10～26中是合法的
            if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') {
                dp[i] +=  dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
