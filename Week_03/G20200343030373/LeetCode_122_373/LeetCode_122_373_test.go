//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
package buy_sell_stock_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestGreedy(t *testing.T) {
	t.Log("Buy Sell Stock: Greedy")

	nums1 := []int{7, 1, 5, 3, 6, 4}
	nums2 := []int{1, 2, 3, 4, 5}
	nums3 := []int{7, 6, 4, 3, 1}
	assert.Equal(t, 7, maxProfit(nums1))
	assert.Equal(t, 4, maxProfit(nums2))
	assert.Equal(t, 0, maxProfit(nums3))
}

//贪心算法：只要后一天价格比前一天高，就在前一天买进、后一天卖出
//限制 或者 使用贪心算法的条件：最多持仓一股，可以0股; 可以买卖无数次; 当天既可买又可卖；无手续费
//O(n)
func maxProfit(prices []int) int {
	var max int
	for i := 0; i <= len(prices)-2; i++ {
		if prices[i+1] > prices[i] {
			max += prices[i+1] - prices[i]
		}
	}
	return max
}
