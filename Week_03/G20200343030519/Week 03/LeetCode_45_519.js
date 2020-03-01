// https://leetcode-cn.com/problems/jump-game-ii/

var jump = function(nums) {
    var steps = 0;
    var len = nums.length;
    var canJumpMax = 0;
    var last_canJumpMax = 0;
    for(var i = 0;i<len-1;i++){
        canJumpMax = Math.max(canJumpMax,i+nums[i]);
        if(last_canJumpMax == i){
            last_canJumpMax= canJumpMax;
            steps++;
        }
        if(last_canJumpMax >= len-1){
            break;
        }
    }
    return steps;
};