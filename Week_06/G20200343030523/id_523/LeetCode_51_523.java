
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        if (n < 1) {
            return result;
        }

        int[][] board = new int[n][n];
        backtrack(board, 0, n, result);
        return result;
    }

    private void backtrack(int[][] board, int row, int n, List<List<String>> result) {

        if (row == n) {
            result.add(trans(board, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!valid(board, row, col, n)) {
                continue;
            }
            board[row][col] = 1;
            backtrack(board, row + 1, n, result);
            board[row][col] = 0;
        }

    }

    private List<String> trans(int[][] board, int n) {
        List<String> each = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder eachRow = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    eachRow.append("Q");
                } else {
                    eachRow.append(".");
                }
            }
            each.add(eachRow.toString());
        }
        return each;
    }

    private boolean valid(int[][] board, int row, int col, int n) {

        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        backtracking.NQueens nQueens = new backtracking.NQueens();
        System.out.println(nQueens.solveNQueens(4));
    }

}
