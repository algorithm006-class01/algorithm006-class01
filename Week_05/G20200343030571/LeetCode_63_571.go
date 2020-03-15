package main

/*
 * @lc app=leetode.cn id=63 lang=golang
 *
 * [63] 不同路径 I
 *
 * https://letcoe-cn.com/problems/unique-paths-ii/description/
 *
 * algorithms
 * Medium (32.9%)
 * Likes:    241
 *Dislikes: 0
 * Total Accepted:    45.4K
 *otal Submissions: 139.4K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]'
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为Start” ）。
 *
 *机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下中标记为“Finish”）。
 *
 *现在考虑网格中有障碍物。那么从左上角到右下角将会有多条不同的路径？
 *
 *
 *
 * 网格中的障物和空位置分别用 1 和 0来表示。
 *
 * 说明：  n 的值均不超过 100。
 *
 * 示例 :
 *
 * 输入:
 * [
 * [0,0,]
 * [,10],
 * [0,0,]
 * ]
 * 输出: 2
 * 解释:
 *3x3 网格的正中间有一个障碍物。
 *从左上角到右下角一共有 2 条不同的路径：
 *1 向右 -> 向右 -> 向下 -> 向下
*2. 向下 -> 向下 -> 向右 -> 向右
 *

 *

//@lc code=start

/*
	思：
分治，将地图中一个点终点的路径这个总问题，不断的化解为【他所能一步到的点到终点的路径的和】的子问题
*/

/*
1. 无效区域 0
2 到了终点 1
3. 否则 递归到下一层
*/

func uniquePathsWithObstacles1(obstacleGrid [][]int) int {
	if obstacleGrid == nil ||
		obstacleGrid[len(obstacleGrid)-1][len(obstacleGrid[0])-1] == 1 {
		return 0
	}

	return countPaths1(obstacleGrid, 0, 0)
}

func countPaths1(obstacleGrid [][]int, row int, col int) int {
	if row >= len(obstacleGrid) || col >= len(obstacleGrid[0]) || obstacleGrid[row][col] == 1 {
		return 0
	}

	if row == len(obstacleGrid)-1 && col == len(obstacleGrid[0])-1 {
		return 1
	}

	return countPaths1(obstacleGrid, row+1, col) + countPaths1(obstacleGrid, row, col+1)
}

/*
思路:
	记忆化搜索。在思路1的前提下，记录中间过程的结果。以达到减重复计算的优化目的

	注意golang的二维切片的初始化，这块没有办法，较繁琐
*/

func uniquePathsWithObstacles2(obstacleGrid [][]int) int {
	if obstacleGrid == nil ||
		obstacleGrid[len(obstacleGrid)-1][len(obstacleGrid[0])-1] == 1 {
		return 0
	}
	memo := make([][]int, len(obstacleGrid))

	for i := range memo {
		memo[i] = make([]int, len(obstacleGrid[0]))
	}

	for i, tempSlice := range memo {
		for j := range tempSlice {
			memo[i][j] = -1
		}
	}

	return countPaths2(obstacleGrid, memo, 0, 0)
}

func countPaths2(ob, memo [][]int, row int, col int) int {
	if row >= len(ob) || col >= len(ob[0]) || ob[row][col] == 1 {
		return 0
	}

	if row == len(ob)-1 && col == len(ob[0])-1 {
		return 1
	}

	if memo[row][col] != -1 {
		return memo[row][col]
	}

	memo[row][col] = countPaths2(ob, memo, row+1, col) + countPaths2(ob, memo, row, col+1)
	return memo[row][col]
}

/*
	思路3
		DP，自底向上
		注意并尽量利用golang中以零值初始化的特性
*/

func uniquePathsWithObstacles3(obstacleGrid [][]int) int {
	if obstacleGrid == nil {
		return 0
	}
	row, col := len(obstacleGrid), len(obstacleGrid[0])
	if row == 0 || col == 0 || obstacleGrid[0] == nil {
		return 0
	}
	if obstacleGrid[0][0] == 1 || obstacleGrid[row-1][col-1] == 1 {
		return 0
	}
	dp := makeSlice(row, col) //二维数组，且元素全部初始化为0

	for i := range dp[0] {
		if obstacleGrid[0][i] == 1 {
			break
		}
		dp[0][i] = 1
	}
	for i := range dp {
		if obstacleGrid[i][0] == 1 {
			break
		}
		dp[i][0] = 1
	}

	for i := 1; i < row; i++ {
		for j := 1; j < col; j++ {
			if obstacleGrid[i][j] == 0 {
				dp[i][j] = dp[i-1][j] + dp[i][j-1]
			}
		}
	}

	return dp[row-1][col-1]
}

/* func makeSlice(row, col int) [][]int {
	slice := make([][]int, row)
	for i := range slice {
		slice[i] = make([]int, col)
	}
	return slice
} */ //刷题的时候在同一包内别处有声明，实现一致

/*
	思路4
		dp优化，将dp数组从二维简化为一维，优化依据是：
			每次迭代中计算路径之后，上一层的计算结果可以丢弃
*/

func uniquePathsWithObstacles4(obstacleGrid [][]int) int {
	if obstacleGrid == nil {
		return 0
	}
	row, col := len(obstacleGrid), len(obstacleGrid[0])
	if row == 0 || col == 0 || obstacleGrid[0] == nil {
		return 0
	}
	if obstacleGrid[0][0] == 1 || obstacleGrid[row-1][col-1] == 1 {
		return 0
	}

	dp := make([]int, col)
	dp[0] = 1

	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			if obstacleGrid[i][j] == 0 {
				if j > 0 {
					dp[j] += dp[j-1]
				}
			} else { // 路障
				dp[j] = 0
			}
		}
	}
	return dp[col-1]
}

// @lc code=end
