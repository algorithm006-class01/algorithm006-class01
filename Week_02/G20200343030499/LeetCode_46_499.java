/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> resultIndices = new ArrayList<>();

        recursor(nums, results, resultIndices, new HashSet<Integer>());
        return results;
    }

    private void recursor(int[] nums, List<List<Integer>> results, List<Integer> currResultIndices, Set<Integer> skip) {
        if (skip.size() == nums.length) {
            List<Integer> resultTemp = new ArrayList<>();
            for (int index : currResultIndices) {
                resultTemp.add(nums[index]);
            }
            results.add(resultTemp);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!skip.contains(i)) {
                currResultIndices.add(i);
                skip.add(i);
                recursor(nums, results, currResultIndices, skip);
                currResultIndices.remove(currResultIndices.size() - 1);
                skip.remove(i);
            }
        }
    }
}
// @lc code=end
