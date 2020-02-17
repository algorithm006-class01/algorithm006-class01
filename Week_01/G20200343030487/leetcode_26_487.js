// 暴力法，反向遍历，重复就删除，最后返回数组长度
function removeDuplicates1(nums) {
  for (let i = nums.length - 1; i > -1; i--) {
    let index = nums.indexOf(nums[i])
    if ( index !== i) {
      nums.splice(i, 1)
    }
  }
  return nums.length
}

// 题目只需要前面元素按顺序排列,所以遇到非重复的元素就将count + 1,同时第count个元素等于当前元素
function removeDuplicates2(nums) {
  let count = 0
  for (let i = 0, len = nums.length; i < len; i++) {
    if (nums[count] !== nums[i]) {
      count++
      nums[count] = nums[i]
    }
  }
  return ++count
}