/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
  for (let i = 0, len = nums.length; i < len; i++) {
    if (nums[i] === target) {
      return i
    }
  }
  return -1
}

var search1 = function(nums, target) {
  if (nums.length === 0) return -1
  let left = 0, right = nums.length - 1, mid
  while (right >= left) {
    mid = parseInt(left + (right - left) / 2)
    if (nums[mid] === target) {
      return mid
    }
    if (nums[left] <= nums[mid]) {
      if (target >= nums[left] && target < nums[mid]) {
        right = mid - 1
      } else {
        left = mid + 1
      }
    } else {
      if (nums[left] > nums[mid]) {
        if (target < nums[right] && target >= nums[mid]) {
          left = mid + 1
        } else {
          right = mid - 1
        }
      }
    }
  }
  return -1
}
