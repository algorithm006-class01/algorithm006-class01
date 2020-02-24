/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {

  //三次旋转
  public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k-1);
    reverse(nums, k, nums.length -1);
  }

  public void reverse(int[] nums, int start, int end) {
    while(start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  //暴力
  public void rotate2(int[] nums, int k) {
    int temp, pre;
    for (int i = 0; i < k; i++) {
      pre = nums[nums.length - 1];
      for ( int j=0; j < nums.length; j++) {
        temp = nums[j];
        nums[j] = pre;
        pre = temp;
      }
    }
  }
}