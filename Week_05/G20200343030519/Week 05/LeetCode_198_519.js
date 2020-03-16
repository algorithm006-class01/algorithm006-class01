// https://leetcode-cn.com/problems/house-robber/

var rob = function(nums) {
    var n = nums.length;
    if(n == 0){
        return 0;
    }
    var prevMax = 0;
    var currMax = 0;
    for(var i = 0; i < n; i++){
        var tmp = currMax;
        currMax = Math.max(currMax,prevMax+nums[i]);
        prevMax = tmp;
    }
    return currMax;
};