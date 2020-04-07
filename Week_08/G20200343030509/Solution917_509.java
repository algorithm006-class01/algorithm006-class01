package com.leetcode.week08;

/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */

import java.util.Stack;

class Solution917_509 {
    public static void main(String[] args) {
        long startTime=System.nanoTime(); //获取开始时间

        Solution917_509 sol = new Solution917_509();
        System.out.println(sol.reverseOnlyLetters("Test1ng-Leet=code-Q!"));

        long endTime=System.nanoTime(); //获取结束时间
        System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
    }

    public String reverseOnlyLetters(String S) {
        Stack<Character> stack = new Stack<>();
        for (char ch: S.toCharArray()) {
            if (Character.isLetter(ch)) {
                stack.push(ch);
            }
        }
        StringBuilder res = new StringBuilder();
        for (char ch: S.toCharArray()) {
            if (Character.isLetter(ch)) {
                res.append(stack.pop());
            }
            else {
                res.append(ch);
            }
        }
        return res.toString();
    }
}