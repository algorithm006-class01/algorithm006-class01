/*
 * @lc app=leetcode.cn id=529 lang=java
 *
 * [529] 扫雷游戏
 */

// @lc code=start
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int nr = board.length, nc = board[0].length;
        int row = click[0], col = click[1];

        if(board[row][col] == 'M')
            board[row][col] = 'X';
        else {
            int count = 0;
            for (int i = -1; i < 2; i ++) {
                for (int j = -1; j < 2; j ++){
                    if (i == 0 && j == 0) continue;
                    int r = row + i, c = col + j;
                    if (r<0||c<0||r>=nr||c>=nc) continue;
                    if (board[r][c] == 'M')
                        count ++;
                }
            }

            if (count > 0) 
                board[row][col] = (char)(count + 48); // '0' ascii code 
            else {
                board[row][col] = 'B';
                for (int i = -1; i < 2; i ++) {
                    for (int j = -1; j < 2; j ++){
                        if (i == 0 && j == 0) continue;
                        int r = row + i, c = col + j;
                        if (r<0||c<0||r>=nr||c>=nc) continue;
                        if (board[r][c] == 'E')
                            updateBoard(board, new int[]{r, c});
                    }
                }   
            }            
            
        }
        return board;
    }
}
// @lc code=end

