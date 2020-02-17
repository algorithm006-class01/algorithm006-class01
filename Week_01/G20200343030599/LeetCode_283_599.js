/*
 * @lc app=leetcode.cn id=283 lang=javascript
 *
 * [283] 移动零
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function (nums) {
  // 解法一：
  // let len = nums.length;
  // let end = len - 1;

  // for (let i = 0; i < len; i++) {

  //   if (i >= end) break;

  //   if (nums[i] === 0) {
  //     nums.splice(i, 1);
  //     i--;
  //     nums.push(0);
  //     end--;
  //   }
  // }

  //解法二：
  let j = 0;
  let len = nums.length;

  for (let i = 0; i < len; i++) {
    if (nums[i] !== 0) {
      nums[j] = nums[i];

      if (i !== j) {
        nums[i] = 0;
      }

      j++;
    }
  }
};
// @lc code=end