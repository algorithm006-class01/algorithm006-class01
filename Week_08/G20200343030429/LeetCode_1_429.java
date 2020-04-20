package com.study.week08;

import java.lang.Math;

public class LeetCode_1_429 {
    public int lengthOfLIS (int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;

        for (int i = 0; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxVal, dp[j]);
                }
            }

            dp[i] = maxval + 1;
        }
        return maxans;
    }
}