package G20200343030391;

import java.util.Arrays;

public class LeetCode_322_391 {

    public static void main(String[] args) {
        int[] coins = {186, 419, 83, 408};

        int amount = 6249;
        int i = new LeetCode_322_391().coinChange(coins, amount);
        System.out.println(i);
    }

    /**
     * 自底向上的动态规划
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        // 特例
        if (coins.length == 0) {
            return -1;
        }
        Arrays.sort(coins);
        // dp[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

}
