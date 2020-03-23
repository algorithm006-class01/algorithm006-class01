package com.jk.work.week06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_51_587 {
    int[] queens;
    Set<Integer> col = new HashSet<>();
    Set<Integer> pie = new HashSet<>();
    Set<Integer> na = new HashSet<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        queens = new int[n];
        dfs(0, n);
        return res;
    }

    void dfs(int r, int n) {
        if (r == n) {
            saveRes(n);
            return;
        }
        //遍历每列
        for (int c = 0; c < n; c++) {
            //判断是否在攻击范围内
            if (isAvailable(r, c)) continue;
            addQueen(r, c);
            dfs(r + 1, n);
            //回溯
            removeQueen(r, c);
        }
    }

    //判断是否在攻击范围内
    boolean isAvailable(int r, int c) {
        return col.contains(c) || pie.contains(r + c) || na.contains(r - c);
    }

    void addQueen(int r, int c) {
        queens[r] = c;
        col.add(c);
        pie.add(r + c);
        na.add(r - c);
    }

    void removeQueen(int r, int c) {
        queens[r] = 0;
        col.remove(c);
        pie.remove(r + c);
        na.remove(r - c);
    }

    void saveRes(int n) {
        List<String> qList = new ArrayList<>();
        for (int col : queens) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i< n; i++) {
                if (i == col) {
                    sb.append("Q");
                    continue;
                }
                sb.append(".");
            }
            qList.add(sb.toString());
        }
        res.add(qList);
    }
}
