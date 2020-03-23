package com.jk.work.week06;

public class LeetCode_37_587 {
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][] blocks = new boolean[9][9];
    char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        //初始化所有已添加的数字
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int idx = board[r][c] - '1';
                    rows[r][idx] = cols[idx][c] = blocks[r/3*3 + c/3][idx] = true;
                }
            }
        }
        dfs(0);
    }

    boolean dfs(int n) {
        if (n == 81) return true;
        int r = n/9;
        int c = n%9;
        if (board[r][c] != '.') return dfs(n + 1);
        for(char k = '1'; k <= '9'; k++) {
            //验证是否可填
            if (isAvailable(r, c, k)) continue;
            //添加数字
            addNum(r, c, k);
            //进入下层
            if (dfs(n + 1)) return true;
            //回溯
            back(r, c, k);
        }
        return false;
    }

    void addNum(int r, int c, char k) {
        int idx = k - '1';
        rows[r][idx] = cols[idx][c] = blocks[r/3*3 + c/3][idx] = true;
        board[r][c] = k;
    }

    void back(int r, int c, char k) {
        int idx = k - '1';
        rows[r][idx] = cols[idx][c] = blocks[r/3*3 + c/3][idx] = false;
        board[r][c] = '.';
    }

    boolean isAvailable(int r, int c, char k) {
        int idx = k - '1';
        return rows[r][idx] || cols[idx][c] || blocks[r/3*3 + c/3][idx];
    }
}
