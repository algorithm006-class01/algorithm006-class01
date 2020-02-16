import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
  public int[] twoSum(int[] nums, int target) {
    //用哈希表记录数字和位置
    Map<Integer,Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      //循环到的数字对应的解
      int key = target - nums[i];
      if (map.containsKey(key)) {
        //如果解存在于map，返回解的位置和现在的位置
        return new int[]{ map.get(key), i };
      }
      //把数字和位置存入哈希表
      map.put( nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }
}