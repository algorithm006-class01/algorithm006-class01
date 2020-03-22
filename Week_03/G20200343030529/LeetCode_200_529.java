class Solution {
    func numIslands(_ grid: [[Character]]) -> Int {
        var count = 0
        var _grid = grid
        for i in 0..<grid.count {
            for j in 0..<grid[i].count {
                if _grid[i][j] == "1" {
                    dfs(&_grid, i, j)
                    count += 1
                }
            }
        }
        return count
    }
    
    private func dfs( _ grid: inout [[Character]], _ row: Int, _ column: Int) {
        if row == grid.count || column == grid[0].count || row < 0 || column < 0 || grid[row][column] == "0" {
            return
        }
        grid[row][column] = "0"
        //左
        dfs(&grid, row, column - 1)
        //右
        dfs(&grid, row, column + 1)
        //上
        dfs(&grid, row - 1, column)
        //下
        dfs(&grid, row + 1, column)
    }
}