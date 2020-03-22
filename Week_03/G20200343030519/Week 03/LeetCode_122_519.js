// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/

var maxProfit = function(prices) {
    var valley = prices[0]; // 谷值
    var peak = prices[0];  // 峰值
    var maxProfit = 0; // 最大利润值
    var lenNeed = prices.length - 1;
    var i = 0;
    while (i < lenNeed) {
        while (i < lenNeed && prices[i] > prices[i + 1]) {
            i++;
        }
        valley = prices[i];
        while (i < lenNeed && prices[i] <= prices[i + 1]) {
            i++;
        }
        peak = prices[i];
        maxProfit += peak - valley;
    }
    return maxProfit;
};