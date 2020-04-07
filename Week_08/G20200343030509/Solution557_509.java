package com.leetcode.week08;

/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

class Solution557_509 {
    public static void main(String[] args) {
        long startTime=System.nanoTime(); //获取开始时间

        Solution557_509 sol = new Solution557_509();
        System.out.println(sol.reverseWords("Let's take LeetCode contest"));

        long endTime=System.nanoTime(); //获取结束时间
        System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word: words) {
            res.append(new StringBuffer(word).reverse().toString() + " ");
        }
        return res.toString().trim();
    }
}