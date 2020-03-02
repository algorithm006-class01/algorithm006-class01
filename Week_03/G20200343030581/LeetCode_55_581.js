/*
 * @lc app=leetcode.cn id=55 lang=javascript
 *
 * [55] 跳跃游戏
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
// 1. 暴力搜索
var canJump = function(nums) {
    function rcanJump(i) {
        if (i == nums.length - 1) {
            return true;
        }

        for (let j = 1; j <= nums[i]; ++j) {
            if (rcanJump(i + j))
                return true;
        }

        return false;
    }

    return rcanJump(0);
};

// 2. 贪心
var canJump = function(nums) {
    let endPoint = nums.length - 1;
    for (let i = endPoint; i >= 0; i--) {
        if (nums[i] + i >= endPoint) {
            endPoint = i;
        }
    }

    return endPoint == 0;
}
// @lc code=end


