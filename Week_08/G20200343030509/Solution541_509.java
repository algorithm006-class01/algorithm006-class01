package com.leetcode.week08;

/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

class Solution541_509 {
    public static void main(String[] args) {
        long startTime=System.nanoTime(); //获取开始时间

        Solution541_509 sol = new Solution541_509();
        System.out.println(sol.reverseStr("abcdefg", 2));

        long endTime=System.nanoTime(); //获取结束时间
        System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
    }

    public String reverseStr(String s, int k) {
        char[] word = s.toCharArray();
        for (int start = 0; start < word.length; start += k*2) {
            reverse(word, start, Math.min(start + k -1, word.length - 1));
        }
        return new String(word);
    }

    private void reverse(char[] word, int start, int end) {
        while (start < end) {
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;
            start++; end--;
        }
    }
}