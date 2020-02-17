/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
/*
 * 1. 只有数组有0时才有计算的意义。所以判断第一个0的位置，如果没有则直接返回
 * 2. 如果找到第一个零，则从此处开始处理之后的元素:
 *  a. 指针pointer始终指向未处理元素中第一个0的位置
 *  b. 指针i发现未处理元素中有非零项则插入到pointer位置。pointer同时后移一位
 *  c. i == nums.length 时返回
 * 
 * 时间复杂度：O(n) 数组中每个元素都用常数项时间处理一遍
 * 空间复杂度：O(1) 没有占用额外空间
 */

class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }

        int pointer = 0;
        while (pointer < len) {
            if (nums[pointer] == 0) {
                break;
            }
            pointer++;
        }
        if (pointer == len) {
            return;
        }
        for (int i = pointer; i < len; i++) {
            if (nums[i] != 0) {
                nums[pointer] = nums[i];
                nums[i] = 0;
                pointer++;
            }
        }
    }
}
// @lc code=end
