/**
 * @param {number[]} nums
 * @return {number}
 */
// 动态规划：dp[i] = max(dp[i-1], 0) + nums[i]
// 用nums作为容器存dp的状态，不用新建dp数组
var maxSubArray = function (nums) {
    for (let i = 1; i < nums.length; i++) {
        nums[i] = Math.max(nums[i - 1], 0) + nums[i]
    }
    return Math.max(...nums)
};