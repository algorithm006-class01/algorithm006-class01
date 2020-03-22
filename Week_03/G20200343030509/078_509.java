/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

class Solution {
  public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      if (nums == null) return result;
      dfs(nums, new ArrayList(), 0, result);
      return result;
  }

  private void dfs(int[] nums, List<Integer> list, int index, List<List<Integer>> result) {
      if (index == nums.length) {
          result.add(new ArrayList<Integer>(list));
          return;
      }

      dfs(nums, list, index + 1, result);
      list.add(nums[index]);
      dfs(nums, list, index + 1, result);

      list.remove(list.size() -1);
  }
}