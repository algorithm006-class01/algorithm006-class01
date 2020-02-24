/**
 * 双指针法
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if (nums.length === 0) return 0 // 边界条件判断
    let i = 0 // 慢指针
    for (let j = 1; j < nums.length; j++) {
        // 快指针遍历
        if (nums[i] !== nums[j]) {
            // 两者所在位置的值不等时，将快指针的值赋值给慢指针后一个位置，同时慢指针后移一位
            i++
            nums[i] = nums[j]
        }
    }
    return i + 1
}
