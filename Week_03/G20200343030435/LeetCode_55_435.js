var canJump = function(nums) {
  var leftPos = nums.length - 1;
  for (var left = nums.length - 1; left >= 0; left--) {
    if (nums[left] + left >= leftPos) {
      leftPos = left;
    }
  }
  return leftPos == 0;
};
