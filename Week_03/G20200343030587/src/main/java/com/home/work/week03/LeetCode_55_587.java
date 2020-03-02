package com.home.work.week03;

public class LeetCode_55_587 {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = lastPos; i >= 0; i--) {
            if (nums[i] + i >= lastPos) lastPos = i;
        }
        return lastPos == 0;
    }
}
