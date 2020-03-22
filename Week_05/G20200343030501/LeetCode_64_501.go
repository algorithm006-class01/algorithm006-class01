package G20200343030501

func minPathSum(grid [][]int) int {
	rowLength := len(grid)
	colLength := len(grid[0])

	for i := 1; i < rowLength; i++ {
		grid[i][0] += grid[i - 1][0]
	}
	for i := 1; i < colLength; i++ {
		grid[0][i] += grid[0][i - 1]
	}
	for row := 1; row < rowLength; row++ {
		for col := 1; col < colLength; col++ {
			grid[row][col] += min(grid[row - 1][col], grid[row][col - 1])
		}
	}
	return grid[rowLength - 1][colLength - 1]
}

func min(a int, b int) int {
	if a > b {
		return b
	} else {
		return a
	}
}