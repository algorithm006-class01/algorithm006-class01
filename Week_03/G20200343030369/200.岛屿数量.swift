/*
 * @lc app=leetcode.cn id=200 lang=golang
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (46.89%)
 * Likes:    389
 * Dislikes: 0
 * Total Accepted:    58.6K
 * Total Submissions: 124.3K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 
 * 示例 1:
 * 
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * 输出: 3
 * 
 * 
 */

// @lc code=start
class Solution {
    func numIslands(_ grid: [[Character]]) -> Int {

    }

    // DFS
    func numIslands0(_ grid: [[Character]]) -> Int {
      if grid.count == 0 {return 0}
      var grid = grid
      var numIslands = 0

      func dfs(_ i: Int, _ j: Int) {
        guard i < grid.count && i >= 0 && j < grid[i].count && j >= 0 else {
          return
        }
        if grid[i][j] == "0" {return}
        grid[i][j] = "0"
        dfs(i-1, j)
        dfs(i+1, j)
        dfs(i, j-1)
        dfs(i, j+1)
      }

      for i in 0..<grid.count {
        for j in 0..<grid[i].count {
          if grid[i][j] == "1" {
            numIslands += 1
            dfs(i, j)
          }
        }
      }
      return numIslands
    }

    // BFS
    func numIslands1(_ grid: [[Character]]) -> Int {
      if grid.count == 0 {return 0}
      var grid = grid
      var queue = [(Int, Int)]()
      var numIslands = 0

      func bfs(_ i: Int, _ j: Int) {
        var queue = [(Int, Int)]()
        queue.append((i, j))
        while !queue.isEmpty {
          let (i, j) = queue.removeFirst()
          grid[i][j] = "0"
          if i - 1 >= 0 && grid[i-1][j] == "1" {queue.append((i-1, j))}
          if j - 1 >= 0 && grid[i][j-1] == "1" {queue.append((i, j-1))}
          if i + 1 < grid.count && grid[i+1][j] == "1" {queue.append((i+1, j))}
          if j + 1 < grid[i].count && grid[i][j+1] == "1" {queue.append((i, j+1))}
        }
      }

      for i in 0..<grid.count {
        for j in 0..<grid[i].count {
          if grid[i][j] == "1" {
            numIslands += 1
            bfs(i, j)
          }
        }
      }
      return numIslands
    }
}
// @lc code=end

