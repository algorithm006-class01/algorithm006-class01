/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
// 1.左->右
var moveZeroes = function(nums) {
    let j = 0;
    for (let i = 0; i < nums.length; ++i) {
        if (nums[i])
            nums[j++] = nums[i];
    }
    for (; j < nums.length; ++j)
        nums[j] = 0;
}
