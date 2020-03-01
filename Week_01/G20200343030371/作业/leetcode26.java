package com.week01;

public class leetcode26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        //通过双指针法进行l指到第一个位置，遍历数组从第二个位置开始
        //如果遇到不想等到数组 则l+1 并且改变为l+1的值
        //这样重复的元素就可以被替换掉，同时相邻的不相等的元素也可以少去很多判断
        int l = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[l] != nums[i]) {
                l++;
                nums[l] = nums[i];
            }
        }
        return l + 1;
    }
}
