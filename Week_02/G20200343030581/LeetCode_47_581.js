/*
 * @lc app=leetcode.cn id=47 lang=javascript
 *
 * [47] 全排列 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
    let res = [];
    function helper(s) {
        if (s == nums.length - 1) {
            res.push(nums.slice())
            return;
        }

        let dic = {};
        for (let i = s; i < nums.length; i++) {
            if (!dic[nums[i]]) {
                dic[nums[i]] = 1;
                swap(nums, s, i);
                helper(s + 1);
                swap(nums, s, i);
            }
        }
    }

    helper(0);
    return res;
};

function swap(nums, i, j) {
    if (i == j) return;
    let tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}
// @lc code=end


