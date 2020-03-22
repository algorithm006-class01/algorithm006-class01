package Week_06.G20200343030395;

public class LeetCode_1_395 {
    public int climbStairs(int n) {
        int memo[] = new int[n+1];
        return cs(0, n, memo);
    }

    public int cs(int i, int n, int memo[])
    {
        if(i > n) {
            return 0;
        }

        if(i == n) {
            return 1;
        }

        if(memo[i] > 0) {
            return memo[i];
        }

        memo[i] = cs(i+1, n, memo) + cs(i+2, n, memo);
        return memo[i];
    }

    public int dp(int n)
    {
        if(n == 1) {
            return 1;
        }

        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
