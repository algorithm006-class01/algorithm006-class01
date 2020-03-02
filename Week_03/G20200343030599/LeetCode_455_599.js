/*
 * @lc app=leetcode.cn id=455 lang=javascript
 *
 * [455] 分发饼干
 */

// @lc code=start
/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function (g, s) {
  g = g.sort((a, b) => a - b);
  s = s.sort((a, b) => a - b);
  let gLen = g.length;
  let sLen = s.length;
  let i = 0;
  let j = 0;
  let maxNum = 0;
  while (i < gLen && j < sLen) {
    if (s[j] >= g[i]) {
      i++;
      j++;
      maxNum++;
    } else {
      j++;
    }
  }
  return maxNum;
};
// @lc code=end
