// 1.暴力解法
// 时间复杂度O(n^2)
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  let res = [];
  for (let i = 0; i < nums.length - 1; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      if (nums[i] + nums[j] == target) {
        res.push(i, j);
      }
    }
  }
  return res;
};

// 2.哈希解法
// 时间复杂度O(n)
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

twoSum = function(nums, target) {
  var hashObj = {};
  for (let i = 0; i < nums.length; i++) {
    var diff = target - nums[i];
    if (hashObj[diff] != undefined) {
      return [hashObj[diff], i];
    }
    hashObj[nums[i]] = i;
  }
};
