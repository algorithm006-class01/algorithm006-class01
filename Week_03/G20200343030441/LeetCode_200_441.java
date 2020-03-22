/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {

        // dfs

        int count_lands = 0;

        if (grid.length == 0) return 0;

        for (int i = 0; i < grid.length; ++i){
            for (int j = 0; j < grid[0].length; ++j){
                if (grid[i][j] == '1'){
                    // 标记同岛屿的 1 为 0 
                    _mark(grid, i, j);
                    count_lands++;
                }
            }
        }

        return count_lands;
    }

    private void _mark(char[][] grid, int x, int y){
        grid[x][y] = '0';
        if (x < grid.length-1){
            if (grid[x+1][y] == '1'){
                _mark(grid, x+1, y);
            }
        }
        if (y < grid[0].length-1){
            if (grid[x][y+1] == '1'){
                _mark(grid, x, y+1);
            }
        }
        if (x > 0){
            if (grid[x-1][y] == '1'){
                _mark(grid, x-1, y);
            }
        }
        if (y > 0){
            if (grid[x][y-1] == '1'){
                _mark(grid, x, y-1);
            }
        }   
    }
}
// @lc code=end

