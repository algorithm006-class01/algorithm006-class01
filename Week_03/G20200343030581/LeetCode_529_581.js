/*
 * @lc app=leetcode.cn id=529 lang=javascript
 *
 * [529] 扫雷游戏
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @param {number[]} click
 * @return {character[][]}
 */
var updateBoard = function(board, click) {
    let row = board.length,
        col = board[0].length;
    function dfs(i, j) {
        if (board[i][j] == "M") {
            board[i][j] = "X";
        } else if (board[i][j] == "E") {
            let M_count = 0;
            for (let dy = -1; dy <= 1; dy++) {
                for (let dx = -1; dx <= 1; dx++) {
                    if (!dx && !dy) continue;
                    let ni = i + dy;
                    let nj = j + dx;
                    if (ni >= 0 && ni < row && nj >= 0 && nj < col) {
                        if (board[ni][nj] == "M")
                            M_count++;
                    }
                }
            }
            board[i][j] = M_count == 0 ? "B" : "" + M_count;
            if (!M_count) {
                for (let dy = -1; dy <= 1; dy++) {
                    for (let dx = -1; dx <= 1; dx++) {
                        if (!dx && !dy) continue;
                        let ni = i + dy;
                        let nj = j + dx;
                        if (ni >= 0 && ni < row && nj >= 0 && nj < col) {
                            dfs(ni, nj);
                        }
                    }
                }
            }
        }
    }
    dfs(click[0], click[1]);
    return board;
};
// @lc code=end


