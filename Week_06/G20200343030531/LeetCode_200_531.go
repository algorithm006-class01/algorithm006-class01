package main

func main() {
	island := [][]byte{{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}}
	numIslands(island)
}

// DFS的写法，找到为"1"的岛屿起始点，对其进行深度优先搜索，
// 并将被搜索到的相邻岛屿全部"沉掉"设置为"0"
// 进行下一轮寻找岛屿
var dx = [4]int{-1, 1, 0, 0}
var dy = [4]int{0, 0, 1, -1}

func numIslands(grid [][]byte) int {
	m := len(grid)
	if m == 0 {
		return 0
	}

	n := len(grid[0])
	count := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == '1' {
				DFS(grid, i, j)
				count++
			}
		}
	}
	return count
}

func DFS(grid [][]byte, i, j int) {
	if i < 0 || j < 0 || i >= len(grid) || j >= len(grid[0]) || grid[i][j] != '1' {
		return
	}

	grid[i][j] = '0'
	for k := 0; k < 4; k++ {
		DFS(grid, i+dx[k], j+dy[k])
	}
}
