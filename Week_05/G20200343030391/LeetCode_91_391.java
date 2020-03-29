package G20200343030391;

public class LeetCode_91_391 {

    public static void main(String[] args) {
        String s = "12";
        int i = new LeetCode_91_391().numDecodings(s);
        System.out.println(i);
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = chars[0] == '0' ? 0 : 1;
        if (s.length() <= 1) return dp[1];
        for (int i = 2; i <= chars.length; i++) {
            int n = (chars[i - 2] - '0') * 10 + (chars[i - 1] - '0');
            if (chars[i - 1] == '0' && chars[i - 2] == '0') {//00X
                return 0;
            } else if (chars[i - 2] == '0') {//01X
                dp[i] = dp[i - 1];
            } else if (chars[i - 1] == '0') {//10X
                if (n > 26) {
                    return 0;
                }
                dp[i] = dp[i - 2];
            } else if (n > 26) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[dp.length - 1];
    }
}
