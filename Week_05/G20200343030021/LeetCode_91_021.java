package dynamicprogramming;

/**
 * #### [91. 解码方法](https://leetcode-cn.com/problems/decode-ways/)
 * 动态规划 从后向前
 * 1.重复性 爬楼梯问题，当前情况数 = 当前后一位 + 后两位的情况
 * 2.定义状态 dp[i] 标明当前情况数
 * 3.DP方程 dp[i] = dp[i + 1] + dp[i + 2]
 *
 * 注意点：特情判断
 */
public class DecodeWays {

    public int numDecodings(String s) {
        int len = s.length();
        if (s == null || len == 0) {
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) == '0') {
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }

        for (int i = len - 2; i >= 0; i--) {
//            特殊情况 为 0 时
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
//            特殊情况 一位和两位的情况
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

}
