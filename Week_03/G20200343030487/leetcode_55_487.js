/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function (nums) {
  let max = 0
  for (let i = 0, len = nums.length; i < len; i++) {
    if (i > max) return false
    max = Math.max(max, i + nums[i])
  }
  return true
}
