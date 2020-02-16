/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
// 双指针解法
var moveZeroes = function(nums) {
  let zeroAtIndex = 0;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] != 0) {
      if (i != zeroAtIndex) {
        nums[zeroAtIndex] = nums[i];
        nums[i] = 0;
      }
      zeroAtIndex++;
    }
  }
};
