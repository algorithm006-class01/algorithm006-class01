package G20200343030391;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class LeetCode_51_391 {

    public static void main(String[] args) {
        int digits = 4;
        List<List<String>> lists = new LeetCode_51_391().solveNQueens(digits);
        System.out.println(lists);
    }

    /**
     * 实时计算位置
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        int[] cols = new int[n];
        int[] fls = new int[2 * n - 1];
        int[] rls = new int[2 * n - 1];
        solve(0, n, board, cols, fls, rls, result);
        return result;
    }

    private void solve(int i, int n, char[][] board, int[] cols, int[] fls, int[] rls, List<List<String>> ans) {
        if (i == n) {
            List<String> strs = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                strs.add(String.valueOf(board[k]));
            }
            ans.add(strs);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (cols[j] == 0 && fls[i + j] == 0 && rls[n - 1 - i + j] == 0) {
                board[i][j] = 'Q';
                cols[j] = 1;
                fls[i + j] = 1;
                rls[n - 1 - i + j] = 1;
                solve(i + 1, n, board, cols, fls, rls, ans);
                board[i][j] = '.';
                cols[j] = 0;
                fls[i + j] = 0;
                rls[n - 1 - i + j] = 0;
            }
        }
    }


    /**
     * @param n
     * @return
     */
    public List<List<String>> solveNQueensByBacktrack(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        Set<Integer> col = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        backtrack(0, n, col, pie, na, stack, result);
        return result;
    }

    /**
     * 回溯
     *
     * @param row
     * @param n
     * @param col
     * @param pie
     * @param na
     * @param stack
     * @param result
     */
    private void backtrack(int row, int n, Set<Integer> col, Set<Integer> pie, Set<Integer> na, Stack<Integer> stack, List<List<String>> result) {
        //terminator
        if (row == n) {
            List<String> board = convert2board(stack, n);
            result.add(board);
            return;
        }
        //process logic 遍历棋盘每一行
        for (int i = 0; i < n; i++) {
            //行，/ , \ 处于未被攻击到的位置
            if (!col.contains(i) && !pie.contains(row - i) && !na.contains(row + i)) {
                //放置queen
                stack.add(i);
                //攻击范围
                col.add(i);
                pie.add(row - i);
                na.add(row + i);

                //drill down
                backtrack(row + 1, n, col, pie, na, stack, result);
                //回溯 重置
                col.remove(i);
                pie.remove(row - i);
                na.remove(row + i);
                stack.pop();
            }
        }
        //reverse
    }

    private List<String> convert2board(Stack<Integer> stack, int n) {
        ArrayList<String> board = new ArrayList<>();
        for (Integer queen : stack) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == queen) {
                    builder.append("Q");
                } else {
                    builder.append(".");
                }
            }
            board.add(builder.toString());
        }
        return board;
    }

}
