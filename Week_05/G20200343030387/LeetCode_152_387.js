/**
 * @param {number[]} nums
 * @return {number}
 */
// 动态规划：
// 每步都需要记录当前的最大值max和最小值min，因为乘积会受符号影响；
// dp[i] >= 0, dp[i] = Math.max(nums[i], max * nums[i])
// dp[i] < 0, swap(max, min), dp[i] = Math.max(nums[i], max * nums[i])
var maxProduct = function (nums) {
    let res = min = max = nums[0]
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] < 0) {
            let tmp = max
            max = min
            min = tmp
        }
        max = Math.max(nums[i], nums[i] * max)
        min = Math.min(nums[i], nums[i] * min)
        res = Math.max(max, res)
    }
    return res
};