/*
 * @lc app=leetcode.cn id=46 lang=javascript
 *
 * [46] 全排列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    let res = [];
    function helper(s) {
        if (s == nums.length - 1) {
            res.push(nums.slice());
            return;
        }

        for (let i = s; i < nums.length; i++) {
            swap(nums, s, i);
            helper(s + 1);
            swap(nums, s, i);
        }
    }

    helper(0);
    return res;
};

function swap(nums, i, j) {
    if (i == j)
        return;
    let tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}
// @lc code=end


