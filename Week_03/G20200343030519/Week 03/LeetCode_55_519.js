// https://leetcode-cn.com/problems/jump-game/

var camJump = function(nums) {
    var lenPoint = nums.length - 1;
    var leftPos = lenPoint;
    for (var left = lenPoint; left >= 0; left--) {
        if (nums[left] + left >= leftPos) {
            leftPos = left;
        }
    }
    return leftPos == 0;
};