import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和 
 */

// @lc code=start
class Solution {
  // 暴力
  public static int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == target - nums[i]) {
                return new int[] { i, j };
            }
        }
    }
    throw new IllegalArgumentException("无");

}

// 哈希表
public static int[] twoSum2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int numB = target - nums[i];
        if (map.containsKey(numB)) {
            return new int[] { map.get(numB), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("无");

}
}
// @lc code=end

