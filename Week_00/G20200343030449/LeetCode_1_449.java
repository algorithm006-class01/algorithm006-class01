import java.util.*;
/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */
/**
 * 构造一个map<target - nums[n], nums[n]>。扫描数组时直接查找target - nums[n]是否在map中
 * 时间/空间复杂度：O(n)/O(n)
 */
// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] { i, map.get(nums[i]) };
            }
            map.put(target - nums[i], i);
        }
        return null; // Won't execute, according to the question desc.
    }
}
// @lc code=end
