/*
 * @lc app=leetcode.cn id=77 lang=javascript
 *
 * [77] 组合
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
    let res = [];
    let com = [];
    function helper(level, s) {
        if (level == k) {
            res.push(com.slice());
            return;
        }

        for (let i = s; i <= n; i++) {
            com.push(i);
            helper(level + 1, i + 1);
            com.pop();
        }
    }

    helper(0, 1);
    return res;
};
// @lc code=end


