package com.leetcode.week07;

/*
 * @lc app=leetcode.cn id=493 lang=java
 *
 * [493] 翻转对
 */


import java.util.Arrays;

class Solution493_509 {
    public static void main(String[] args) {
        long startTime=System.nanoTime(); //获取开始时间

        Solution493_509 sol = new Solution493_509();
        int[] numbers = {1,5,2,5,1,5};

        System.out.println(sol.reversePairs(numbers));

        long endTime=System.nanoTime(); //获取结束时间
        System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
    }

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && nums[i]/2.0 > nums[j]) j++;
            count += j - (mid + 1);
        }
        Arrays.sort(nums, left, right +1);
        return count;
    }

}