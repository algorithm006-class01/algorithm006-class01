/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
// @date Mar 22 2020
// @solution backtracking
class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board, 0);
    }

    boolean dfs (char[][] board, int pos) {
        if (pos == 81) return true;

        int r = pos / 9, c = pos % 9;
        if (board[r][c] != '.') return dfs(board, pos + 1);
        char digit = '0';
        for (boolean valid: getValid(board, r, c)) {
            digit ++;
            if (!valid) continue;
            board[r][c] = digit;
            if (dfs(board, pos + 1)) return true;
        }

        board[r][c] = '.';
        return false;
    }
    boolean[] getValids(char[][] board, int r, int c) {
        boolean[] valids = new boolean[9];
        Arrays.fill(valids, true);
        for (int i = 0; i < 9; i ++) {
            char[] toValid = {
                board[r][i], // current row
                board[i][c], // current column
                board[r/3*3+i/3][c/3*3+i%3] // current block
            };
            // if any toValid has digit, then false.
            for (char tv: toValid) 
                if (tv != '.')
                    valids[tv - '1'] = false;
        }
        return valid;
    }
}
// @lc code=end

