// https://leetcode-cn.com/problems/move-zeroes/

var moveZeroes = function(nums) {
    var idx = 0;
    for (var j = 0; i < nums.length; i++) {
        if (nums[i] !== 0) {
            nums[idx] = nums[i];
            nums[i] = idx === i ? nums[i] : 0;
            idx++;
        }
    }
};