/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
/**
 * 双指针法
 * 一个指针指向当前遍历到的最后一个零元素，另一个是自然遍历的；
 * 如果两指针指向的值不等（即当前指针指向非零元素），交换两指针的值，两指针同时往后移一位；
 * 否则只是当前指针移一位；
 */
var moveZeroes = function(nums) {
    let lastNonZeroFoundAt = 0
    for (let current = 0; current < nums.length; current++) {
        if (nums[current] !== 0) {
            if (current !== lastNonZeroFoundAt) {
                nums[lastNonZeroFoundAt] = nums[current]
                nums[current] = 0
            }
            lastNonZeroFoundAt++
        }
    }
}
