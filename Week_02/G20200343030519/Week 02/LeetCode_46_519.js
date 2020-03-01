// https://leetcode-cn.com/problems/permutations/

var permute = function(nums) {
    var n = nums.length;
    let res = [];
    let tmpPath = [];
    let backtrack = (tmpPath) => {
        if (tmpPath.length == n) {
            res.push(tmpPath);
            return;
        }
        for (let i = 0; i < n; i++) {
            if (!tmpPath.includes(nums[i])) {
                tmpPath.push(nums[i]);
                backtrack(tmpPath.slice());
                tmpPath.pop();
            }
        }
    }
    backtrack(tmpPath);
    return res;
};