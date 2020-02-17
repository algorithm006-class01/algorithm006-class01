// 暴力法：双重循环每次移动数组一步
function rotateArr(nums, k) {
  for (let i = 0; i < k; i++) {
      let temp = nums[nums.length - 1]
      for (let j = nums.length - 1; j > 0; j--) {
          nums[j] = nums[j - 1]
      }
      nums[0] = temp
  }
  return nums
}
