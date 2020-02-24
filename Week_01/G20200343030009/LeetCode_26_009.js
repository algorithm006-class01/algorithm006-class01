/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
  //快慢指针
  let slow = 0;
  let quick = 1;
  for (; quick < nums.length; quick++) {
      if (nums[slow] !== nums[quick]) {
          // 快慢指针指向的数据不等，快指针数据赋值到慢指针下个位置
          nums[++slow] = nums[quick]
      }
      // 当快慢指针指向的数据相等（重复数据）, 只是快指针单独向右移动；
      // 直到不等时，进入上面if，将快指针数据赋值到慢指针下个位置
  }
  return slow+1
};