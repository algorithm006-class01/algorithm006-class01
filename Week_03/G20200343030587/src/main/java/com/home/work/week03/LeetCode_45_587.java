package com.home.work.week03;

public class LeetCode_45_587 {
    public int jump(int[] nums) {
        int k = 0;
        int step = 0;
        int end = 0;
        //这里有个小细节，因为是起跳的时候就 + 1 了，
        //如果最后一次跳跃刚好到达了最后一个位置，那么遍历到最后一个位置的时候就会再次起
        //跳，这是不允许的，因此不能遍历最后一个位置
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            k = Math.max(k, nums[i] + i);
            //遇到边界，就更新边界，并且步数加一
            if (i == end) {
                step++ ;
                end = k;
            }
        }
        return step;
    }
}
