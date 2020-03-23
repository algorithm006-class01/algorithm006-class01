package com.leetcode.week06;

/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution037_509 {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;

        boolean flag = solve(board);
        System.out.println(flag);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, i, j, ch)) {
                            board[i][j] = ch;

                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == ch) return false;
            if (board[row][i] == ch) return false;
            if (board[3 * (row/3) + i/3][3 * (col/3) + i%3] == ch) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long startTime=System.nanoTime(); //获取开始时间

        Solution037_509 sol = new Solution037_509();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};


        sol.solveSudoku(board);
        printBoard(board);

        long endTime=System.nanoTime(); //获取结束时间
        System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            String line = "";
            for (int j = 0; j < board[0].length; j++) {
                line += board[i][j] + ",";
            }
            System.out.println(line);
        }
    }

}