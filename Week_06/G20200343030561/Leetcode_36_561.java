/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9], col = new int[9][9], box = new int[9][9];
        for (int r = 0; r < 9; r ++) {
            for (int c = 0; c < 9; c ++) {
                if (board[r][c] == '.') continue;
                int val = (int) board[r][c] - '1';
                if (++row[r][val] > 1) return false;
                if (++col[c][val] > 1) return false;
                if (++box[(r/3)*3 + (c/3)][val] > 1) return false;
            }
        }
        return true;
    }
}
// @lc code=end

