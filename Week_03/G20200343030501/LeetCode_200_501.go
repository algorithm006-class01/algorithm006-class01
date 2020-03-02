package G20200343030501

func numIslands(grid [][]byte) int {
	rowLength := len(grid)
	if rowLength == 0 {
		return 0
	}
	colLength := len(grid[0])
	count := 0

	for rowIndex := 0; rowIndex < rowLength; rowIndex++ {
		for colIndex := 0; colIndex < colLength; colIndex++ {
			if (int)(grid[rowIndex][colIndex]) == '1' {
				clearToZero(grid, rowIndex, colIndex)
				count += 1
			}
		}
	}
	return count
}

func clearToZero(grid [][]byte, rowIndex int, colIndex int) {
	rowLength := len(grid)
	colLength := len(grid[0])
	if rowIndex < 0 || colIndex < 0 ||
		rowIndex >= rowLength || colIndex >= colLength ||
		grid[rowIndex][colIndex] == '0' {
		return
	}
	grid[rowIndex][colIndex] = '0'
	clearToZero(grid, rowIndex - 1, colIndex)
	clearToZero(grid, rowIndex + 1, colIndex)
	clearToZero(grid, rowIndex, colIndex - 1)
	clearToZero(grid, rowIndex, colIndex + 1)
}