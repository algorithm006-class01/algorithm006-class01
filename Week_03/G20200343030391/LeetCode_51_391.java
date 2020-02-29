package G20200343030391;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class LeetCode_51_391 {

    public static void main(String[] args) {
        int digits = 4;
        List<List<String>> lists = new LeetCode_51_391().solveNQueens_backtrack(digits);
        System.out.println(lists);
    }

    /**
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens_backtrack(int n) {
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
