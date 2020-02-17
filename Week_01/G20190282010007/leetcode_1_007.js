// 题目: 两数之和
/**
 * 题目描述：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */

 // 解题语言: javaScript

 // 解题

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    // 暴力解题，两重循环
    for(let i = 0; i < nums.length -1 ; i++) {
      for(let j = i + 1; j < nums.length; j++) {
          if (nums[j] === target - nums[i]) {
              return [i, j]
          }
      }
  }
};