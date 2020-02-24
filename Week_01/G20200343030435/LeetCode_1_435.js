let twoSum = function(nums, target) {
  const items = [];
  for (let i = 0; i < nums.length; i++) {
    const diff = target - nums[i];
    if (items[diff] !== undefined) {
      return [i, items[diff]];
    }
    items[nums[i]] = i;
  }
};
