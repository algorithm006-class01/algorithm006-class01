package com.jk.work.week06;

public class LeetCode_36_587 {

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] blocks = new int[9][9];
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    //初始值为0, 行列块记录个数，不记录真实的数字，一共会出现
                    //1-9个数字并且每个数字出现9次 按照真实数字值分区记录个数 大于1说明不合法
                    if (++rows[board[i][j] - '1'][j] > 1 ||
                            ++cols[board[i][j] - '1'][i] > 1 ||
                            ++blocks[board[i][j] - '1'][(i/3)*3 + j/3] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
