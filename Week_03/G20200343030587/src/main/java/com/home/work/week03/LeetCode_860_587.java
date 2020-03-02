package com.home.work.week03;

public class LeetCode_860_587 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int m : bills) {
            if (m == 5) {
                ++five;
            } else if (m == 10) {
                if (--five < 0) return false;
                ++ten;
            }else {
                if (ten > 0) {
                    --ten;
                    if (--five < 0) return false;
                } else {
                    if ((five -= 3) < 0) return false;
                }
            }
        }
        return true;
    }
}
