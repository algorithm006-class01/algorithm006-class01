package com.jk.week07;

public class LeetCode_52_587 {

    private int n;
    private int count = 0;
    public int totalNQueens(int n) {
        this.n = n;
        dfs(0,0,0,0);
        return count;
    }

    private void dfs(int row, int col, int pie, int na) {
        if (row == n) {
            count++;
            return;
        }
        //当前可放皇后位置
        //((1 << n) - 1) 初始 n个1 代表可以放皇后
        //col pie na 0代表可以放皇后 1不可以
        //所有取反 在& 表示可以当前可以放皇后位置
        int bits = (((1 << n) - 1)) & (~(col | pie | na));
        // bits == 0 表示没有位置可以放皇后了 结束循环
        while (bits != 0) {
            //取最低位的1 （如 ：1100 －>100， 1110 -> 10 ）即在p位置可放入皇后
            int p = bits & -bits;
            //去掉最低1 表示在p位置上放入皇后
            bits = bits & (bits - 1);
            //当p位置放置皇后后
            //col | p 表示列被占用
            //(pie | p) << 1 表示pie 被占用（即左移一位 进入递归后 下次放入皇后该位置不可放）
            //(na | p) >> 1 同上 na 需要右移一位
            dfs(row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
        }
    }
}
