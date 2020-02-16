/*
 * @lc app=leetcode.cn id=66 lang=javascript
 *
 * [66] 加一
 */

// @lc code=start
/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function (digits) {
  const len = digits.length;

  //从末位开始
  for (let i = len - 1; i >= 0; i--) {
    //数组的值 + 1 (末位 + 1)
    digits[i]++;

    //末位和10取模，如果结果为0，则说明有进位，如果结果不为0，则说明没有进位可直接返回+1之后的数组
    digits[i] %= 10;

    if (digits[i] !== 0) return digits;
  }

  //如果原数组+1后所有位都需要进位，则数组的长度需要扩充一位
  digits = [...Array(len + 1)].map(_ => 0); //声明一个长度为len+1的所有值为0的数组
  digits[0] = 1;
  return digits;
};
// @lc code=end