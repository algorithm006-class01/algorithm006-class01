/*
 * @lc app=leetcode.cn id=189 lang=javascript
 *
 * [189] 旋转数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function (nums, k) {
  let len = nums.length

  //方法一：暴力求解
  /*
  for (let i = 0; i < k; i++) {
    let current = nums[len - 1];
    for (let j = 0; j < len; j++) {
      [nums[j], current] = [current, nums[j]];
    }
  }
  */

  //方法二：把数组尾部的元素删除后添加在数组头部
  /*
  for (let i = 0; i < k; i++) {
    nums.unshift(nums.pop())
  }
  */

  //方法三：找到数组旋转的索引位置 len - k % n
  let reversePoint = len - k % len;
  reversePoint !== 0 && (nums.splice(0, 0, ...nums.splice(reversePoint, k)))

};
// @lc code=end