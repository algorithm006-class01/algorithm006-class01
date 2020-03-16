package G20200343030391;

public class LeetCode_70_391 {

    public static void main(String[] args) {
        System.out.println(climbStairs_2(3));
    }


    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int climbStairs_1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 记忆搜索
     * @param n
     * @return
     */
    public static int climbStairs_2(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        return help(memo, n);
    }

    private static int help(int[] memo, int n) {
        if (n <= 1) {
            return 1;
        }
        if (memo[n] == 0) {
            memo[n] = help(memo, n - 1) + help(memo, n - 2);
        }
        return memo[n];
    }

    /**
     * 傻递归
     * @param n
     * @return
     */
    public static int climbStairs_3(int n) {
        return n <= 1 ? 1 : climbStairs_3(n - 1) + climbStairs_3(n - 2);
    }


}
