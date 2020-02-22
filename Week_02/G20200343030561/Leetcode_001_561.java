import java.util.*;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// 暴力法
// @data Feb 12 2020
/* class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        for(var i = 0; i < nums.length; i ++) {
            for (var j = i + 1; j < nums.length; j ++) {
                if (nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
          
        return new int[0];
    }
} */

// 两遍哈希表
// @date Feb 19 2020
/* class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i ++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }
        return new int[0];
    }
} */
// @lc code=start
// 一遍哈希表
// @data Feb 19 2020
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; ++ i) {
            int complement = target - nums[i];
            if (map.containsKey(complement))
                return new int[] {i, map.get(complement)};
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
// @lc code=end

