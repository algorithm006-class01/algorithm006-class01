/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */


// class Solution {
//     int res = 0;
//     public int totalNQueens(int n) {
//         if (n == 0) return 0;
//         dfs(n, 0, 0, 0, 0);
//         return res;
//     }
//     void dfs(int n, int r, int c, int lr, int ll) { // row, col, lower right, lower left
//         if (r == n) {
//             res ++;
//             return;
//         }
//         int bit = (~ (c | lr | ll)) & ((1 << n) - 1);
//         while (bit != 0) {
//             int q = bit & -bit;
//             dfs(n, r+1, c|q, (lr|q)>>1, (ll|q)<<1);
//             bit &= bit - 1;
//         }
//     }
// }

// class Solution {
//     int res = 0;
//     public int totalNQueens(int n) {
//         if (n == 0) return 0;
//         dfs((1 << n) - 1, 0, 0, 0);
//         return res;
//     }
//     void dfs(int n, int c, int lr, int ll) { // col, lower right, lower left
//         if (c == n) {
//             res ++;
//             return;
//         }
//         int bit = (~ (c | lr | ll)) & n;
//         while (bit != 0) {
//             int q = bit & -bit;
//             dfs(n, c|q, (lr|q)>>1, (ll|q)<<1);
//             bit &= bit - 1;
//         }
//     }
// }

// @lc code=start
// @date Mar 28 2020
class Solution {
    int res = 0;
    public int totalNQueens(int n) {
        if (n == 0) return 0;
        dfs((1 << n) - 1, 0, 0, 0);
        return res;
    }
    void dfs(int b, int c, int lr, int ll) { // board, column, lower right, lower left
        if (c == b) {
            res ++;
            return;
        }
        for (int qs = (~ (c | lr | ll)) & b; qs != 0; qs &= qs - 1) {
            int q = qs & (- qs);
            dfs(b, c | q, (lr | q) >> 1, (ll | q) << 1);
        }
    }
}
// @lc code=end

