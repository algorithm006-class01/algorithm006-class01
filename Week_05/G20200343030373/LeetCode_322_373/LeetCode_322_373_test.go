//https://leetcode-cn.com/problems/coin-change/
package coin_change_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestCoinChange(t *testing.T) {
	assert.Equal(t, 3, coinChange([]int{1, 2, 5}, 11))
	assert.Equal(t, -1, coinChange([]int{2}, 3))
}

func coinChange(coins []int, amount int) int {
	//状态定义：dp[i]为凑成i元需要的最小硬币数
	//最终结果：dp[amount]
	dp := make([]int, amount+1)    //假设都是1元，凑2元，则遍历的i为0\1\2，长度为3
	dp[0] = 0                      //初始值：凑成0元需要0个
	for i := 1; i <= amount; i++ { //将初始值设置为不可达的数字
		dp[i] = amount + 1
	}

	//状态方程：dp[i] = min{dp[i-a], dp[i-b], dp[i-c]} + 1
	//凑成当前数值nowAmount，等于之前凑成数值nowAmount-coin的最小值再加1
	for nowAmount := 1; nowAmount <= amount; nowAmount++ {
		for _, coin := range coins {
			if nowAmount >= coin { //当前要凑的数值要大于等于硬币面额
				dp[nowAmount] = min(dp[nowAmount], dp[nowAmount-coin]+1)
			}
		}
	}

	if dp[amount] > amount {
		return -1
	}
	return dp[amount]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
