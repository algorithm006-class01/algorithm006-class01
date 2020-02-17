/* 
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
*/

// 双指针解法，由于是排序好的数组，就看他左右两边

/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
  let p = 0;
  for (let q = 1; q < nums.length; q++) {
    if (nums[q] !== nums[p]) {
      nums[++p] = nums[q];
    }
  }
  return p + 1;
};
