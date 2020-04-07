package com.leetcode.week08;

/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

import java.util.HashMap;

class Solution205_509 {
    public static void main(String[] args) {
        long startTime=System.nanoTime(); //获取开始时间

        Solution205_509 sol = new Solution205_509();
        System.out.println(sol.isIsomorphic("ab", "aa"));

        long endTime=System.nanoTime(); //获取结束时间
        System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character,Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if (!map.containsKey(sch)) {
                if (map.containsValue(tch)) return false;
                map.put(sch, tch);
            }
            else if (map.get(sch) != tch) {
                return false;
            }
        }
        return true;
    }
}