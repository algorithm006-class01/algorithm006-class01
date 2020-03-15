// 题目: 最小路径和
/**
 * 题目描述：
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。
 */

// 解题语言: javaScript

// 解题

/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function (grid) {
    let l = grid.length, h = grid[0].length;
    let temp = [];
    for (let i = 0; i < l; i++) {
        temp[i] = [];
    }
    // console.log(temp)
    for (let i = 0; i < l; i++) {
        for (let j = 0; j < h; j++) {
            if (i == 0 && j == 0) {
                temp[i][j] = grid[i][j]
            }
            else if (i == 0) {
                temp[i][j] = temp[i][j - 1] + grid[i][j]
            }
            else if (j == 0) {
                temp[i][j] = temp[i - 1][j] + grid[i][j]
            }
            else {
                temp[i][j] = grid[i][j] + Math.min(temp[i][j - 1], temp[i - 1][j])
            }
        }
    }
    // console.log(temp)
    return temp[l - 1][h - 1]
}