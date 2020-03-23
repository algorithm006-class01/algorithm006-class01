package Week_06;

/**
 * 爬楼梯,类似题目解法基本一致
 */
public class Leetcode_070_001 {
    /**
     * 斐波那契数列法
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n < 4) {
            return n;
        }

        int f1 = 1, f2 = 2, f3 = 3;

        for (int i = 3; i < n + 1; i++) {
            f3 = f2 + f1;
            f1 = f2;
            f2 = f3;
        }

        return f3;
    }

    /**
     * 动态规划法
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n < 4) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
