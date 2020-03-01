// https://leetcode-cn.com/problems/permutations-ii/

var permuteUnique = function(nums) {
    let n = nums.length;
    nums = nums.sort((a,b) => {return a - b});
    let res = [];
    let tmpPath = [];
    let hash = {};
    let backtrack = (tmpPath) => {
        if(tmpPath.length == n){
            res.push(tmpPath);
            return;
        }
        for(let i = 0;i < n;i++){
            if(hash[i] || (i > 0 && !hash[i-1] && nums[i-1] == nums[i])) continue;
            hash[i] = true;
            tmpPath.push(nums[i]);
            backtrack(tmpPath.slice());
            hash[i] = false;
            tmpPath.pop();
        }
    }
    backtrack(tmpPath);
    return res;
};