/*
  给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
  示例 1:
  输入:
  11110
  11010
  11000
  00000
  输出: 1
 
  示例 2:
  输入:
  11000
  11000
  00100
  00011
  输出: 3
*/

/**
 * @param {character[][]} grid
 * @return {number}
 */

let row
let column
var numIslands = function(grid) {
  if (!grid.length) return 0
  row = grid.length
  if (!row) return 0
  let column = grid[0].length
  let count = 0
  // 遍历行
  for (let i = 0; i < row; i++) {
    // 遍历列
    for (let j = 0; j < column; j++) {
      // 当前节点为岛屿
      if (grid[i][j] === '1') {
        // 数量加1
        count += 1
        // 启动深度优先搜索，将相邻（前后左右）的岛屿夷为平地（置为海洋）
        DFSMasking(i, j, grid)
      }
    }
  }
  return count
};
function DFSMasking (i, j, grid) {
  // terminator -- 到达边界或遇到海洋
  if (i < 0 || j < 0 || i >= row || j >= column || grid[i][j] != '1') return
  // 当前节点夷为平地（置为海洋-0）
  grid[i][j] = '0'
  // 前后左右四个方向下探下去
  DFSMasking(i-1, j, grid)
  DFSMasking(i+1, j, grid)
  DFSMasking(i, j-1, grid)
  DFSMasking(i, j+1, grid)
}