import java.util.*;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
/*******未通过*******
 * 思路： 建立一个Map(key: 加多少等于0, value: nums的下标)
 * 遍历nums中所有两个数的组合，利用组合的结果来从map中找到第三个数的下标
 * 未通过，因为虽然下标同，但值可以相同。这个方法不能去除相同的值。例如：
 * input: [-1,0,1,2,-1,-4]
 * expected: [[-1,-1,2],[-1,0,1]]
 * output: [[-1,0,1],[-1,2,-1],[0,1,-1]]
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // key: 加多少等于0, value: nums的下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(-nums[i], i);
        }

        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                Integer thirdNumber = map.get(nums[i] + nums[j]);
                if (thirdNumber != null && thirdNumber > j) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(nums[thirdNumber]);
                    results.add(result);
                }
            }
        }
        return results;
    }
}
// @lc code=end
