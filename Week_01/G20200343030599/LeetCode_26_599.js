/*
 * @lc app=leetcode.cn id=26 lang=javascript
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {

  if (nums.length === 0) return 0;

  //双指针法：i指针用来遍历数组，j指针用来指向当前不重复数组的最后一项
  //注意审题：数组是已经排好序的数组，所以如果有重复元素，那么它们一定连续出现的
  //且不需要考虑数组中超出新长度后面的元素
  let j = 0;
  for (let i = 1; i < nums.length; i++) {
    if (nums[i] !== nums[j]) {
      j++;
      nums[j] = nums[i];
    }
  }

  return j + 1;
};
// @lc code=end