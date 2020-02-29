/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 求众数
 */

class Solution {
  // 排序
  public int majorityElement(int[] nums) {
      Arrays.sort(nums);
      return nums[nums.length/2];
  }

  //分治
  public int majorityElement2(int[] nums) {
    int length = nums.length;
    int res = seprateCount(nums, 0, length -1);
    return res;
}

private int seprateCount(int[] nums, int low, int high) {
   if (low == high) return nums[low];

    int mid = (high - low) / 2 + low;
    int left = seprateCount(nums, low, mid);
    int right = seprateCount(nums, mid + 1, high);

    if (left == right) return left;
    int leftCount = countMaj(nums, low, mid, left);
    int rightCount = countMaj(nums, mid + 1, high, right);

    return leftCount > rightCount ? left : right;
}

private int countMaj(int[] nums, int start, int end, int right) {
    int count = 0;
    for (int i=start; i <= end; i++){
        if(nums[i] == right) count++;
    }

    return count;
}
}