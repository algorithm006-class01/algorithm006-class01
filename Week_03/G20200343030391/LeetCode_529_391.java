package G20200343030391;

import java.util.Arrays;

public class LeetCode_529_391 {

    public static void main(String[] args) throws InterruptedException {
        char[][] board = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };
        int[] click = {3, 0};


        char[][] chars = new LeetCode_529_391().updateBoard(board, click);
        System.out.println(Arrays.deepToString(chars));
        int[] click2 = {1, 2};
        char[][] chars2 = new LeetCode_529_391().updateBoard(chars, click2);
        System.out.println(Arrays.deepToString(chars2));
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        int[][] round = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        dfs(click[0], click[1], board, round);
        return board;
    }

    private void dfs(int r, int c, char[][] board, int[][] round) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return;
        }
        if (board[r][c] == 'E') {
            board[r][c] = 'B';
            //查周围的雷
            int minesCount = 0;
            for (int i = 0; i < round.length; i++) {
                int newR = r + round[i][0];
                int newC = c + round[i][1];
                if (newR < 0 || newR >= board.length || newC < 0 || newC >= board[0].length) {
                    continue;
                }
                if (board[newR][newC] == 'M') {
                    minesCount++;
                }
            }
            if (minesCount == 0) {
                for (int i = 0; i < round.length; i++) {
                    int newR = r + round[i][0];
                    int newC = c + round[i][1];
                    dfs(newR, newC, board, round);
                }
            } else {
                board[r][c] = (char) (minesCount + '0');
            }
        } else if (board[r][c] == 'M') {
            board[r][c] = 'X';
        }
    }
}
