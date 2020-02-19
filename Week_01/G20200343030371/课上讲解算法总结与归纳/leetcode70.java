package com;

public class leetcode70 {
    public int climbStairs(int n) {
        //本题目无法使用暴力破解法 因为n是不确定的，遇到这样的题目首先找最近重复子元素
        //推导：f(n) = f(n-1) + f(n-2);
        //解法: f3 = f2 + f1 f4 =f3 + f2.....
        //n 必须大于2否则返回n
        if (n <= 2) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 0;//根据已知的阶梯
        for (int i = 3; i < n + 1; i++) {
            f3 = f1 + f2;//第3阶梯 3 第4阶梯 5
            f1 = f2;//2
            f2 = f3;//3
        }
        return f3;
    }
}
