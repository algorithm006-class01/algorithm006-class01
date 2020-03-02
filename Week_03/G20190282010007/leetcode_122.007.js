// 题目: 买卖股票的最佳时机II
/**
 * 题目描述：
 *给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。
你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。


 */

 // 解题语言: javaScript

 // 解题

/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    // 这好像就是个暴力解法 --- 只要明天比今天价格高，就进行买卖
    let res = 0
    for (let i = 0; i < prices.length; i++) {
        if (prices[i+1] > prices[i]) {
            res += prices[i + 1] - prices[i]
        }
    }
    return res
};