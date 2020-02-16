/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 *
 * https://leetcode-cn.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (39.94%)
 * Likes:    483
 * Dislikes: 0
 * Total Accepted:    96.6K
 * Total Submissions: 239.1K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释: 
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 
 * 说明:
 * 
 * 
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * 
 * 
 */

// @lc code=start
class Solution {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3, 4, 5 };
        rotate(nums, 2);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

  // 方法 1：暴力
  public static void rotate(int[] nums, int k) {
    int temp;
    int previouse;

    for (int i = 0; i < k; i++) {
        previouse = nums[nums.length - 1];
        for (int j = 0; j < nums.length; j++) {
            temp = nums[j];
            nums[j] = previouse;
            previouse = temp;
        }
    }
}

// 方法 2：使用额外的数组
public static void rotate2(int[] nums, int k) {
    int[] newNums = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
        newNums[(i + k) % nums.length] = nums[i];
    }
    for (int i = 0; i < nums.length; i++) {
        nums[i] = newNums[i];
    }
}

// 方法 3：使用环状替换
public static void rotate3(int[] nums, int k) {
    k = k % nums.length;
    int count = 0;
    for (int i = 0; count < nums.length; i++) {
        int current = i;
        int prev = nums[i];
        do {
            int next = (current + k) % nums.length;
            int temp = nums[next];
            nums[next] = prev;
            prev = temp;
            current = next;
            count++;
        } while (i != current);
    }
}
// 方法 4：使用反转
public static void rotate4(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
}
public static void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}
}
// @lc code=end
