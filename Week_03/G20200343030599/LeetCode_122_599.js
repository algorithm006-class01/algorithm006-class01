/*
 * @lc app=leetcode.cn id=122 lang=javascript
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
  const length = prices.length
  // 总利润
  let t = 0
  // 当前持有的价格
  let h;
  for (let i = 0; i < length; i++) {
    const today = prices[i]
    const today1 = prices[i + 1]
    // 买入
    if (h === undefined && today < today1) {
      h = today
      continue
    }
    // 正常交易日卖出
    if (today > today1 && h < today && h !== undefined) {
      t = today - h + t
      h = undefined
      continue
    }
    // 最后交易日卖出
    if (today1 === undefined && h < today && h !== undefined) {
      t = today - h + t
      h = undefined
    }

  }
  return t
};
// @lc code=end
