package datast.dp;

public class LeetCode_322_611 {

    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;
            if (coins.length == 0) return -1;
            int[] dp = new int[amount + 1];
            for (int i = 1; i <= amount; i++){
                int min = Integer.MAX_VALUE;
                for (int coin : coins){
                    if (i - coin >= 0 && dp[i - coin] < min){
                        min = dp[i - coin] + 1;
                    }
                }
                dp[i] = min;
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }
}
