/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] state = new int[m][n];

        for (int i = 0; i < m; ++i) state[i][0] = 1;
        for (int j = 0; j < n; ++j) state[0][j] = 1;

        for (int i = 1; i < m; ++i){
            for (int j = 1; j < n; ++j){
                state[i][j] = state[i-1][j] + state[i][j-1];
            }
        }

        return state[m-1][n-1];
    }
}
// @lc code=end

