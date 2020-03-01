package com.week01;

public class leetcode189 {
    public void rotate(int[] nums, int k) {
        int res;
        //双循环旋转数组
        for (int i = 0; i < k; i++) {
            res = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = res;
                res = temp;
            }
        }
    }
}
