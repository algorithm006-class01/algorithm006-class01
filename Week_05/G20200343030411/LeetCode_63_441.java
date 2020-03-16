/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        int[][] states = new int[m][n];

        for (int i = 0; i < m; ++i){
            if (obstacleGrid[i][0] == 1) break;
            states[i][0] = 1;
        }
        for (int j = 0; j < n; ++j){
            if (obstacleGrid[0][j] == 1) break;
            states[0][j] = 1;
        }

        for (int i = 1; i < m; ++i){
            for (int j = 1; j < n; ++j){
                if (obstacleGrid[i][j] == 1) states[i][j] = 0;
                else states[i][j] = states[i-1][j] + states[i][j-1];
            }
        }

        return states[m-1][n-1];
    }
}
// @lc code=end

