public class Solution {
    public char[][] UpdateBoard(char[][] board, int[] click) {
        Dfs(board, click[0], click[1]);
        return board;
    }

    public void Dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.Length || y < 0 || y >= board[0].Length) {
            return;
        }

        char result = board[x][y];
        if (result == 'B') {
            return;
        }

        if (result == 'M') {
            board[x][y] = 'X';
            return;
        }

        if (result == 'E') {
            int count = SuroundMinesNum(board, x, y);
            if (count > 0) {
                board[x][y] = (char)(48 + count);
            }
            else {
                board[x][y] = 'B';

                for (int i = x - 1; i <= x + 1; i++) {
                    for (int j = y - 1; j <= y + 1; j++) {
                        if (i == x && j == y) {
                            continue;
                        } 

                        Dfs(board, i, j);
                    }
                }
            }
        }
    }

    public int SuroundMinesNum(char[][] board, int x, int y) {
        int num = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i == x && j == y) {
                    continue;
                }

                if (i < 0 || i >= board.Length || j < 0 || j >= board[0].Length) {
                    continue;
                }

                if (board[i][j] == 'M') {
                    num++;
                }
            }
        }

        return num;
    }
}