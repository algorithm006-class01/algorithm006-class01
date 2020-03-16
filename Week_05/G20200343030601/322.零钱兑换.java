/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 *
 * https://leetcode-cn.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (37.83%)
 * Likes:    379
 * Dislikes: 0
 * Total Accepted:    44.8K
 * Total Submissions: 118.5K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * 给定不同面额的硬币 coins 和一个总金额
 * amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 
 * 示例 1:
 * 
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3 
 * 解释: 11 = 5 + 5 + 1
 * 
 * 示例 2:
 * 
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * 
 */

// @lc code=start
import java.util.Arrays;
class Solution {

    // f(amount) = 1 + min (f(amount - coin1)
    //                      f(amount - coin2)
    //                        ...
    //                      f(amount - coinn))
    // 递归处理：超时
    public int coinChangeRecursive(int[] coins, int amount) {
        if (amount <= 0) return amount;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int remain = amount - coins[i];
            int remainCount = coinChangeRecursive(coins, remain);
            if (remainCount >= 0 && remainCount < minCount)
                minCount = remainCount;
        }
        return minCount == Integer.MAX_VALUE? -1 : minCount + 1;
    }

    // 递归处理 + 备忘录: 还是超时了
    public int coinChangeRMem(int[] coins, int amount) {
        int[] mem = new int[amount + 1];
        return coinChangeHelper(coins, amount, mem);
    }    
    private int coinChangeHelper(int[] coins, int amount, int[] mem) {
        if (amount <= 0) return amount;

        if (mem[amount] > 0) return mem[amount];

        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int remain = amount - coins[i];
            int remainCount = coinChangeHelper(coins, remain, mem);
            if (remainCount >= 0 && remainCount < minCount)
                minCount = remainCount + 1;
        }
        mem[amount] = minCount == Integer.MAX_VALUE? -1 : minCount;
        return mem[amount];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);                    
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
 
    }

    // 自下而上的DP，计算每一个小于amount值时，需要的最小coin数
    public int coinChangeDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
// @lc code=end

