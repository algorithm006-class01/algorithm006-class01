/*

    time complexity: O(9^m), m represents the number of blanks to be filled in
    space complexity: O(1)

*/
class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) { //每個位置一一放入去try
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; //set value

                            if (solve(board)) return true; // resursive

                            board[i][j] = '.'; // backtrack
                        }

                    }
                    return false;
                }
            }
        }
        return true;
    }


    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) { //判斷9個格子
            char rowVal = board[row][i];
            if (rowVal != '.' && rowVal == c) return false;

            char colVal = board[i][col];
            if (colVal != '.' && colVal == c) return false;

            // 因為沒有用set, 所以判斷式是這樣, 這裡再針對(i,j) 去判斷9宮格內是否有c了
            char boxVal = board[3*(row/3) + i/3][3*(col/3) + i%3];
            if (boxVal != '.' && boxVal == c) return false;
        }
        return true;
    }
}