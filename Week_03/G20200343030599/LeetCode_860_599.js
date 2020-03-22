/*
 * @lc app=leetcode.cn id=860 lang=javascript
 *
 * [860] 柠檬水找零
 */

// @lc code=start
/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function (bills) {
  //贪心算法
  let five = 0;
  let ten = 0;
  let len = bills.length;
  for (let i = 0; i < len; i++) {
    if (bills[i] == 5) {
      five++;
    } else if (bills[i] == 10) {
      if (five == 0) {
        return false
      };
      five--;
      ten++;
    } else if (bills[i] == 20) {
      if (ten > 0 && five > 0) {
        ten--;
        five--;
      } else if (five >= 3) {
        five -= 3;
      } else {
        return false;
      }
    }
  }
  return true;
};
// @lc code=end
