let search = function(nums, target) {
  let left = 0,
    right = nums.length - 1,
    mid = 0;
  while (left < right) {
    mid = parseInt((left + right) / 2);
    if (nums[0] > target && nums[mid] < target) {
      left = mid + 1;
    } else if (
      nums[0] <= nums[mid] &&
      (nums[0] > target || nums[mid] < target)
    ) {
      left = mid + 1;
    } else {
      right = mid;
    }
  }

  return left === right && nums[left] === target ? left : -1;
};
