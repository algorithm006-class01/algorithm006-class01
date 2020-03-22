package com.study.week03;

import java.util.Arrays;

/**
 * @author Abner
 * @date 2020/3/1 22:15
 * @email songkd90@163.com
 * @description 分发饼干
 */
public class LeetCode_3_429 {

    /**
     * 解法：贪心算法，胃口最小的先满足，留下份量大的来尽量满足胃口大的小朋友
     * @param s
     * @param g
     * @return
     */
    public static int assignCookies(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gNum = 0;
        int sNum = 0;

        while (gNum < g.length && sNum < s.length) {
            // 分量大于胃口，满足，目标转移到下一个小朋友，同时也代表满足的数量
            if (s[sNum] >= g[gNum]) {
                gNum++;
            }
            // 下一份饼干
            sNum++;
        }
        return gNum;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,1};
        System.out.println(assignCookies(g, s));
    }
}
