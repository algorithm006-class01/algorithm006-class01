package G20200343030391;


public class LeetCode_79_391 {

    public static void main(String[] args) {
        char[][] board = {
                {'a'}
        };
        boolean abcced = new LeetCode_79_391().exist(board, "b");
        System.out.println(abcced);
    }

    /**
     * DFS
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {

        int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int row = board.length;
        int clo = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < clo; j++) {
                if (board[i][j] == word.charAt(0)) {
                    dfs(i, j, row, clo, 0, board, direction, word);
                }
                if (find) {
                    return true;
                }
            }
        }
        return find;
    }

    boolean find;

    private void dfs(int i, int j, int row, int clo, int index, char[][] board, int[][] direction, String word) {
        if (index == word.length() - 1) {
            find = true;
            return;
        }
        if (board[i][j] == word.charAt(index)) {
            char orign = board[i][j];
            board[i][j] = '#';
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if ((newX >= 0 && newX < row && newY >= 0 && newY < clo) && board[newX][newY] != '#' && board[newX][newY] == word.charAt(index + 1)) {
                    dfs(newX, newY, row, clo, index + 1, board, direction, word);
                }
                if (find) {
                    return;
                }
            }
            board[i][j] = orign;
        }
    }
}
