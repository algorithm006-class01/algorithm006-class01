package main

/*
 * @lc app=leetcode.cn id=188 lang=golang
 *
 * [188] 买卖股票的最佳时机 IV
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 *
 * algorithms
 * Hard (29.32%)
 * Likes:    182
 * Dislikes: 0
 * Total Accepted:    14.7K
 * Total Submissions: 49.9K
 * Testcase Example:  '2\n[2,4,1]'
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 *
 *
 * 示例 2:
 *
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4
 * 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 *
 *
 */

// @lc code=start

/*
	dp方程：
	定义状态： i -> 天数; k -> 已达成交易总数; b (0,1) -> 当天对股票是否持有 0否1持有
			  value -> 直到当天的最大利润
	dp[i][k][1] = Max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
	dp[i][k][0] = Max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])

	max_k

	dp[-1][k][0] = 0
	解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
	dp[-1][k][1] = -infinity
	解释：还没开始的时候，是不可能持有股票的，用负无穷表示这种不可能。
	dp[i][0][0] = 0
	解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0 。
	dp[i][0][1] = -infinity
	解释：不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。

*/

/*
	不考虑K的情况：
	dp[i][1] = Max(dp[i-1][1], dp[i-1][0] - prices[i])
	dp[i][0] = Max(dp[i-1][0], dp[i-1][1] + prices[i])
*/
/* const MININFIN int = -99999

func maxProfit(k int, prices []int) int {
	if prices == nil {
		return 0
	}
	n := len(prices)
	if n == 0 {
		return 0
	}

	if k > n/2 {
		return maxProfitNoTradelimit(n, prices)
	}

	dp := make3dSlice(n, k+1, 2)

	//基准形态
	for j := 0; j <= k; j++ {
		if j == 0 {
			dp[0][0][0] = 0
			dp[0][0][1] = MININFIN
		}
		dp[0][j][0] = 0
		dp[0][j][1] = -prices[0]
	}

	for i := 1; i < n; i++ {
		for j := 1; j <= k; j++ {
			dp[i][j][1] = MaxInt(dp[i-1][j][1], dp[i-1][j-1][0]-prices[i])
			dp[i][j][0] = MaxInt(dp[i-1][j][0], dp[i-1][j][1]+prices[i])
		}
	}

	return dp[n-1][k][0]
}

func maxProfitNoTradelimit(n int, prices []int) int {
	dp := make2dSlice(n, 2)

	dp[0][1] = -prices[0]
	dp[0][0] = 0

	for i := 1; i < n; i++ {
		dp[i][1] = MaxInt(dp[i-1][1], dp[i-1][0]-prices[i])
		dp[i][0] = MaxInt(dp[i-1][0], dp[i-1][1]+prices[i])
	}

	return dp[n-1][0]
}

func MaxInt(i, j int) int {
	if i > j {
		return i
	}

	return j
}

func make2dSlice(i, j int) [][]int {
	sli := make([][]int, i)
	for n := range sli {
		sli[n] = make([]int, j)
	}
	return sli
}

func make3dSlice(i, j, k int) [][][]int {
	sli := make([][][]int, i)
	for n := range sli {
		sli[n] = make([][]int, j)
		for m := range sli[n] {
			sli[n][m] = make([]int, k)
		}
	}

	return sli
}
 */
// @lc code=end
