// remove-duplicates-from-sorted-array

var removeDuplicates = function(nums) {
    var slowIdx = 0;
    for (var i = 1; i < nums.length; i++) {
        if (nums[slowIdx] != nums[i]) {
            nums[slowIdx + 1] = nums[i];
            slowIdx += 1;
        }
    }
    // nums.splice(slowIdx + 1, nums.length);
    return slowIdx + 1;
};