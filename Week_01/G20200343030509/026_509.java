/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length < 2) {
      return nums.length;
    } 
    //快慢指针
    int pre = 0, next =1;
    while(next < nums.length) {
      //如果不相等
      if(nums[pre] != nums[next]) {
        //并且快指针不是慢指针的下一个
        if(next - pre > 1) {
          //把快指针的值赋给慢指针的下一个
          nums[pre + 1] = nums[next];
        };
        //把慢指针往后移
        pre++;
      }
      next++;
    }
    return pre + 1;
  }
}