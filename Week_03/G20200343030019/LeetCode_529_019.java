class Solution {
    int maxX = 0;
    int maxY = 0;
    public char[][] updateBoard(char[][] board, int[] click) {
        maxX = board.length - 1;
        maxY = board[0].length - 1;
        minesweeper(board, click[0], click[1]);
        return board;
    }

    private void minesweeper(char[][] board, int x, int y) {
        if (x < 0 || x > maxX || y < 0 || y > maxY) {
            return;
        }
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return;
        }
        if (board[x][y] != 'E') {
            return;
        }
        int count = mineCount(board, x, y);
        if (count > 0) {
            board[x][y] = (char) ((int) '1' + count -1);
            return;
        }
        board[x][y] = 'B';
        minesweeper(board, x + 1, y);
        minesweeper(board, x, y + 1);
        minesweeper(board, x - 1, y);
        minesweeper(board, x, y - 1);
        minesweeper(board, x + 1, y + 1);
        minesweeper(board, x - 1, y + 1);
        minesweeper(board, x - 1, y - 1);
        minesweeper(board, x + 1, y - 1);
    }

    private int mineCount(char[][] board, int x, int y) {
        int count = 0;
        if (x < maxX && board[x + 1][y] == 'M') count ++;
        if (y < maxY && board[x][y + 1] == 'M') count ++;
        if (x > 0 && board[x - 1][y] == 'M') count ++;
        if (y > 0 && board[x][y - 1] == 'M') count ++;
        if (x < maxX && y < maxY && board[x + 1][y + 1] == 'M') count ++;
        if (x > 0 && y > 0 && board[x - 1][y - 1] == 'M') count ++;
        if (x < maxX && y > 0 && board[x + 1][y - 1] == 'M') count ++;
        if (x > 0 && y < maxY && board[x - 1][y + 1] == 'M') count ++;
        return count;
    }
}