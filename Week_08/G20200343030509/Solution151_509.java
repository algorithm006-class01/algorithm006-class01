package com.leetcode.week08;

/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution151_509 {
    public static void main(String[] args) {
        long startTime=System.nanoTime(); //获取开始时间

        Solution151_509 sol = new Solution151_509();
        System.out.println(sol.reverseWords("  hello world!  "));

        long endTime=System.nanoTime(); //获取结束时间
        System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
    }

    public String reverseWords(String s) {
        s = s.trim();
        List<String> array = Arrays.asList(s.split("\\s+"));
        Collections.reverse(array);
        return String.join(" ", array);
    }
}