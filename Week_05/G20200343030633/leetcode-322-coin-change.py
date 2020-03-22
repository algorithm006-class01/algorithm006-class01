# 寻找最优子结构：S的最少硬币数，是由S减去最后一枚币值大小的最少硬币数+1
# 定义状态：F(S) = F(S-C)+1
# DP方程：F(S) = min(F(S-C) C IN [1,2,5]) + 1
import functools

#自顶向下
def coinChange(coins, amount):
    def dp(rem, coinsx):
        if rem < 0:
            return -1
        if rem == 0:
            return 0
        mini = int(1e9)
        for coin in coinsx:
            res = dp(rem - coin, coinsx)
            if 0 <= res < mini:
                mini = res + 1
        return mini if mini < int(1e9) else -1

    if amount < 1:
        return 0
    return dp(amount, coins)

# 自下而上
def coinChange1(coins, amount):
    MAX = float('inf')
    dp = [0] + [MAX] * amount

    for i in range(1, amount + 1):
        dp[i] = min([dp[i - c] if i - c >= 0 else MAX for c in coins]) + 1

    print(dp)
    return [dp[amount], -1][dp[amount] == MAX]

#拼不出来的不用算，change1的内外循环对调
def coinChange2(coins, amount):
    dp = [float('inf')] * (amount + 1)
    dp[0] = 0

    for coin in coins:
        for x in range(coin, amount + 1):
            dp[x] = min(dp[x], dp[x - coin] + 1)
    print(dp)
    return dp[amount] if dp[amount] != float('inf') else -1



print(coinChange2([6, 8, 9], 8))
