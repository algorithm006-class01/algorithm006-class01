package G20200343030391;


public class LeetCode_31_391 {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean validSudoku = new LeetCode_31_391().isValidSudoku(board);
        System.out.println(validSudoku);

    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                for (int k = 0; k < 9; k++) {
                    if (k != j && board[i][k] != '.' && board[i][k] == c) return false;
                    if (k != i && board[k][j] != '.' && board[k][j] == c) return false;
                    int blockX = 3 * (i / 3) + k / 3;
                    int blockY = 3 * (j / 3) + k % 3;
                    if (blockX != i && blockY != j && board[blockX][blockY] != '.' && board[blockX][blockY] == c) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
