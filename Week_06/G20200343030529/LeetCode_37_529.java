class Solution {
    int n = 9;
    boolean[][] rows = new boolean[n][10];
    boolean[][] columns = new boolean[n][10];
    boolean[][] blocks = new boolean[n][10];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    int pos = board[i][j] - '0';
                    rows[i][pos] = true;
                    columns[j][pos] = true;
                    blocks[blockIndex(i, j)][pos] = true;
                }
            }
        }

        solveHelper(board, 0, 0);
    }

    private boolean solveHelper(char[][] board, int row, int column) {
        if (column == n) {
            return true;
        }

        while (board[row][column] != '.') {
            if (row + 1 < n) {
                row += 1;
            } else {
                row = 0;
                column += 1;
            }
            if (column == n) {
                return true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (rows[row][i] || columns[column][i] || blocks[blockIndex(row, column)][i]) {
                continue;
            }
            board[row][column] = (char) (i + '0');
            rows[row][i] = true;
            columns[column][i] = true;
            blocks[blockIndex(row, column)][i] = true;

            int nextRow = row;
            int nextColumn = column;
            if (nextRow + 1 < n) {
                nextRow += 1;
            } else {
                nextRow = 0;
                nextColumn += 1;
            }

            if (!solveHelper(board, nextRow, nextColumn)) {
                board[row][column] = '.';
                rows[row][i] = false;
                columns[column][i] = false;
                blocks[blockIndex(row, column)][i] = false;
            } else {
                return true;
            }
        }
        return false;
    }

    private int blockIndex(int row, int column) {
        return (row / 3) * 3 + column / 3;
    }
}