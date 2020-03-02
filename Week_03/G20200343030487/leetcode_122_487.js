/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
  let max = 0
  for (let i = 0, len = prices.length; i < len - 1; i++) {
    if (prices[i] < prices[i + 1]) {
      max += prices[i + 1] - prices[i]
    }
  }
  return max
}
