package com.study.week07;

public class LeetCode_2_429 {
    /**
     * 神奇的运算
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}