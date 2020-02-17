import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution015 {

  public static void main( String[] args) {
    int[] nums = {-1, 0 , 1, 2, -1, -4};
    List<List<Integer>> list = threeSum2(nums);
    System.out.println(list);
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> list = new LinkedList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i == 0 || (i > 0 && nums[i - 1] != nums[i])) {
        int left = i + 1, right = nums.length - 1;
        while (left < right) {
          if (nums[i] + nums[left] + nums[right] == 0) {
            list.add(Arrays.asList(nums[i], nums[left], nums[right]));
            while (left < right && nums[left] == nums[left + 1]) {
              left++;
            }
            while (left < right && nums[right] == nums[right - 1]) {
              right--;
            }
            left++;
            right--;
          } else if (nums[i] + nums[left] + nums[right] > 0) {
            right--;
          } else {
            left++;
          }
        }
      }
    }
    return list;
  }

  public static List<List<Integer>> threeSum2(int[] nums) {
    List<List<Integer>> list = new LinkedList<>();
    //暴力法，时间没通过
    for (int i = 0; i < nums.length -2; i++) {
      for (int j = i +1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if ( nums[i] + nums[j] + nums[k] == 0) {
            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
            Collections.sort(temp);
            if ( !list.contains(temp)) {
              list.add(temp);
            }
          }
        }
      }
    }
    return list;
  }
}