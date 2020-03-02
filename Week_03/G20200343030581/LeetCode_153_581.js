/*
 * @lc app=leetcode.cn id=153 lang=javascript
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    let low = 0,
        high = nums.length - 1;
    if (nums[low] <= nums[high]) {
        return nums[low];
    }
    while (low <= high) {
        let mid = low + ((high - low) >> 1);

        if (nums[mid] > nums[mid + 1])
            return nums[mid + 1];
        if (nums[mid - 1] > nums[mid])
            return nums[mid];
        
        if (nums[mid] >= nums[0]) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
};
// @lc code=end


