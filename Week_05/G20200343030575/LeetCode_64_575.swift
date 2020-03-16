/*
 * @lc app=leetcode.cn id=64 lang=swift
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    func minPathSum(_ grid: [[Int]]) -> Int {
        guard grid.count > 1 else {
            return grid[0].reduce(0, +)
        }
        
        var results = Array<Int>.init(repeating: 0, count: grid[0].count)
        var sum = 0
        for i in 0..<grid[0].count {
            sum += grid[0][i]
            results[i] = sum
        }
        
        for row in 1..<grid.count{
            results[0] += grid[row][0]
            for column in 1..<grid[0].count {
                results[column] = grid[row][column] + min(results[column - 1], results[column])
            }
        }
        return results.last!
    }
}
// @lc code=end

