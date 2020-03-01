// 1. 暴力 O(n^2)
var twoSum = function(nums, target) {
    for (let i = 0; i < nums.length - 1; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target)
                return [i, j];
        }
    }
};

// 2.Hash O(n)
var twoSum = function (nums, target) {
    let dic = {};
    for (let i = 0; i < nums.length; i++) {
        if (dic[nums[i]] != undefined) {
            return [dic[nums[i]], i];
        } 
        dic[target - nums[i]] = i;
    }
}
