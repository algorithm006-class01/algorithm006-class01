let permute = function(nums) {
  const swap = (nums, i, j) => {
    [nums[i], nums[j]] = [nums[j], nums[i]];
  };
  const dfs = (cur, index, len, nums, res) => {
    if (cur.length === len) {
      res.push(cur.concat());
      return;
    }
    for (let i = index; i < nums.length; i++) {
      swap(nums, i, index);
      cur.push(nums[index]);
      dfs(cur, index + 1, len, nums, res);
      cur.pop();
      swap(nums, i, index);
    }
  };
  const len = nums.length;
  const res = [];
  dfs([], 0, len, nums, res);
  return res;
};
