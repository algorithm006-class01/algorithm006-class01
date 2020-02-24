let rotate = function(nums, k) {
  const n = nums.length;
  k %= n;
  const reverse = (start, end) => {
    while (start < end) {
      const tmp = nums[start];
      nums[start] = nums[end];
      nums[end] = tmp;
      start++;
      end--;
    }
  };
  reverse(0, n - 1);
  reverse(0, k - 1);
  reverse(k, n - 1);
  return nums;
};
