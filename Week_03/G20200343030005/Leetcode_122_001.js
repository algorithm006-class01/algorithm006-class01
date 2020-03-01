/**
122. 买卖股票的最佳时机 II
*/

/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
  var res = 0;
  var len = prices.length;
  for (var i = 0; i < len - 1; i++) {
    var diff = prices[i + 1] - prices[i];
    if (diff > 0) {
      res += diff;
    }
  }
  return res;
};