/*
 * @lc app=leetcode.cn id=1 lang=javascript
 *
 * [1] 两数之和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
  //方法一：两重暴力循环
  /*
  for (let i = 0; i < nums.length - 1; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      if (nums[j] === target - nums[i]) return [i, j];
    }
  }
  */

  //方法二：Hash表
  let temp = [];

  for (let i = 0; i < nums.length; i++) {
    if (temp[nums[i]] !== undefined) {
      return [temp[nums[i]], i]
    }
    temp[target - nums[i]] = i;
  }

};
// @lc code=end