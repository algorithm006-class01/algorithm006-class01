// move-zeroes
var moveZeroes = function(nums) {
    if (nums.length <= 0) return;

    var numberPointer = 0;
    for (var i = 0; i < nums.length; i++) {
        if (nums[i] !== 0) {
            nums[numberPointer] = nums[i];
            numberPointer+=1;
        }
    }
    for (;numberPointer < nums.length; numberPointer++) {
        nums[numberPointer] = 0;
    }
};