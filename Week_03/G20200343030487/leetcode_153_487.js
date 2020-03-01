/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
  if (nums.length === 1) return nums[0]
  for (let i = 0, len = nums.length; i < len - 1; i++) {
    if (nums[i] < nums[i + 1]) {
      return nums[i]
    }
  }
  return nums[0]
}

var findMin1 = function(nums) {
  let left = 0, right = nums.length - 1
  while (right >= left) {
    let mid = parseInt(left + (right - left) / 2)
    if (nums[mid] > nums[mid + 1]) {
      return nums[mid + 1]
    }
    if (nums[mid - 1] > nums[mid]) {
      return nums[mid]
    }
    if (nums[mid] > nums[0]) {
      left = mid + 1
    } else {
      right = mid - 1
    }
  }
  return -1
}
