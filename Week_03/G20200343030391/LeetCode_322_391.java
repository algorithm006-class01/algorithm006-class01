package G20200343030391;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_322_391 {

    public static void main(String[] args) {
        int[] coins = {186, 419, 83, 408};

        int amount = 1234;
        int i = new LeetCode_322_391().coinChange(coins, amount);
        System.out.println(i);
    }

    /**
     * 傻递归
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_0(int[] coins, int amount) {
        help(0, coins, amount);
        return foolish == Integer.MAX_VALUE ? -1 : foolish;
    }

    int foolish = Integer.MAX_VALUE;

    private void help(int count, int[] coins, int amount) {
        //有效路径，更新次数
        if (amount == 0) {
            foolish = Math.min(foolish, count);
            return;
        }
        //无效路径，丢弃
        if (amount < 0) {
            return;
        }
        for (int j = 0; j < coins.length; j++) {
            help(count + 1, coins, amount - coins[j]);
        }
    }

    /**
     * 自底向上的动态规划
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_1(int[] coins, int amount) {
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

    /**
     * 贪心
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        coinChange(coins.length - 1, coins, 0, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    int ans = Integer.MAX_VALUE;

    private void coinChange(int index, int[] coins, int count, int needAmount) {
        if (needAmount == 0) {
            ans = Math.min(count, ans);
            return;
        }
        if (index < 0) {
            return;
        }

        int i = needAmount / coins[index];
        for (int k = i; k >= 0 && count + k < ans; k--) {
            coinChange(index - 1, coins, count + k, needAmount - k * coins[index]);
        }
    }

}
