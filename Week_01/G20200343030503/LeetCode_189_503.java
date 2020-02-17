/**
 * 
 * homework
 * https://leetcode-cn.com/problems/rotate-array/
 * 
 * 题目要点:  1. 使用取余的方式判断i+k大于len 则从头开始 arr[(i + k) % nums.length]
 *					 2. 需要重新开辟一个数组去存放旋转之后的值 用于改变原数组的顺序 
 * time complexity O(n) 
 * space complexity O(n)
 * 关于官方题解中的 使用环状和使用反转 现阶段理解比较困难
 * 
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
    }
}