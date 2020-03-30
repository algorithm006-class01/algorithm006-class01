import java.util.*;
/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @solution
// class Solution {
//     List<List<String>> res = new ArrayList<>();
//     public List<List<String>> solveNQueens(int n) {
//         int[][] board = new int[n][n];
//         bt(board, 0, n);
//         return res;
//     }
//     private void bt(int[][] board, int i, int n) {
//         if (i == n) {
//             List<String> l = new ArrayList<>();
//             for (var k = 0; k < n; k++) {
//                 StringBuilder sb = new StringBuilder();
//                 for (var m = 0; m < n; m++) {
//                     sb.append((board[k][m] == 0) ? '.' : 'Q');
//                 }
//                 l.add(sb.toString());
//             }
//             res.add(l);
//             return ;
//         }
//         for (int j = 0; j < n; j ++) {
//             if (available(i, j, board)) {
//                 board[i][j] = 1;
//                 bt(board, i+1, n);
//                 board[i][j] = 0;
//             }
//         }
//     }
//     private boolean available(int i, int j, int[][] board) {
//         for (int h = 0; h < i; h ++) 
//             if (board[h][j] == 1) return false;
        
//         int max = board.length;
//         int offset;
//         for (offset = 0; i - offset >= 0 && j + offset < max; offset ++) 
//             if (board[i-offset][j+offset] == 1) return false;
        
//         for (offset = 0; i + offset < max && j - offset >= 0; offset ++) 
//             if (board[i+offset][j-offset] == 1) return false;
        
//         for (offset = 0; i - offset >= 0 && j - offset >= 0; offset ++) 
//             if (board[i-offset][j-offset] == 1) return false;

//         for (offset = 0; i + offset < max && j + offset < max; offset ++) 
//             if (board[i+offset][j+offset] == 1) return false;

//         return true;
//     }
// }


// @date Mar 22 2020
// @solution backtracking best
// class Solution {
//     int rl, cl;
//     List<List<String>> res = new ArrayList<>();
//     public List<List<String>> solveNQueens(int n) { 
//         rl = cl = n;
//         dfs(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
//         return res;
//     }
//     void dfs(List<Integer> queenInRows, List<Integer> lowerRight, List<Integer> lowerLeft) {
//         int r = queenInRows.size();
//         if (r == rl) {
//             List<String> solution = new ArrayList<>();
//             for (int idx: queenInRows) {
//                 solution.add(".".repeat(idx) + "Q" + ".".repeat(rl - 1 - idx));
//             } 
//             res.add(solution);
//             return;
//         }
//         for (int c = 0; c < cl; c ++) {
//             if (queenInRows.contains(c)) continue;
//             // if x1 - y1 = x2 - y2, [x1, y1] and [x2, y2] are in same lowerright line;
//             if (lowerRight.contains(r - c)) continue;
//             // if x1 + y1 = x2 + y2, [x1, y1] and [x2, y2] are in same lowerleft line; 
//             if (lowerLeft.contains(r + c)) continue; 
//             queenInRows.add(c);
//             lowerRight.add(r - c);
//             lowerLeft.add(r + c);
//             dfs(new ArrayList<>(queenInRows), new ArrayList<>(lowerRight), new ArrayList<>(lowerLeft));
//             int lastIdx = r;
//             queenInRows.remove(lastIdx);
//             lowerRight.remove(lastIdx);
//             lowerLeft.remove(lastIdx);
//         }
//     }
// }

// @lc code=start
class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) { 
        dfs(n, new ArrayList<>(), 0, 0, 0, 0);
        return res;
    }
    void dfs(int n, List<String> board, int r, int c, int lr, int ll) {
        if (r == n) {
            res.add(board);
            return;
        }
        int bit = (~(c | lr | ll)) & ((1 << n) - 1);
        while (bit != 0) {
            int q = bit & (-bit);
            board.add(String.format("%" + String.valueOf(n) + "s", Integer.toBinaryString(q)).replaceAll("[\\s|0]", ".").replace("1", "Q"));
            dfs(n, new ArrayList<>(board), r + 1, c | q, (lr | q) >> 1, (ll | q) << 1);
            board.remove(r);
            bit = bit & (bit  - 1);
        }
    }
}

// @lc code=end

