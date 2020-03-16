package Week_05.G20200343030395;

public class LeetCode_2_395 {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i=1; i<s.length(); i++) {
            if(s.charAt(i) == '0') {//s=0的时候
                if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {//等于1或2的情况
                    dp[i+1] = dp[i-1];
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6')) {
                    dp[i+1] = dp[i] + dp[i-1];
                } else {
                    dp[i+1] = dp[i];
                }
            }
        }

        return dp[s.length()];
    }
}
