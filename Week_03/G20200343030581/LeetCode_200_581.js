/*
 * @lc app=leetcode.cn id=200 lang=javascript
 *
 * [200] 岛屿数量
 */

// @lc code=start
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    let count = 0;
    let row = grid.length;
    if (!row) return count;
    let col = grid[0].length;
    
    let dx = [1, 0, -1, 0],
        dy = [0, -1, 0, 1];

    function dfs(i, j) {
        grid[i][j] = "0";

        for (let k = 0; k < 4; k++) {
            let ni = i + dy[k];
            let nj = j + dx[k];
            if (ni >= 0 && ni < row && nj >= 0 && nj < col) {
                if (grid[ni][nj] == "1") {
                    dfs(ni, nj);
                }
            }
        }
    }
    for (let i = 0; i < row; i++) {
        for (let j = 0; j < col; j++) {
            if (grid[i][j] == "1") {
                count++;
                dfs(i, j);
            }
        }
    }

    return count;
};
// @lc code=end


