package com.leetcode.week05;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

class Solution032_509 {
    public static void main(String[] args) {
        long startTime=System.nanoTime(); //获取开始时间

        Solution032_509 sol = new Solution032_509();
        System.out.println(sol.longestValidParentheses(")()(()(())("));

        long endTime=System.nanoTime(); //获取结束时间
        System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
    }

    public int longestValidParentheses(String s) {
        int max = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i > 2) dp[i] = dp[i-2] + 2;
                    else dp[i] = 2;
                }
                else if (i - dp[i-1] > 0 && s.charAt(i - dp[i-1] -1) == '(') {
                    if (i - dp[i-1] >= 2) dp[i] = dp[i-1] + dp[i - dp[i-1] -2] + 2;
                    else dp[i] = dp[i-1] + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}