public class Solution_70 {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int dp = 0, pre1 = 1, pre2 = 2;
        for (int i = 3; i <= n; ++i) {
            dp = pre1 + pre2;
            pre1 = pre2;
            pre2 = dp;
        }
        return dp;
    }
}
