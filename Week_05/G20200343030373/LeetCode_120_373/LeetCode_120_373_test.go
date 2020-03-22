//https://leetcode-cn.com/problems/triangle/description/
package triangle_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestTriangle(t *testing.T) {
	triangle := [][]int{
		{2},
		{3, 4},
		{6, 5, 7},
		{4, 1, 8, 3},
	}
	assert.Equal(t, 11, minimumTotal(triangle))
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

func minimumTotal(triangle [][]int) int {
	return method3(triangle)
}

//状态定义：dp[i,j]：底层到当前点路径的最小值 - 最终结果：dp[0,0]
//状态方程：dp[i,j] = min(dp[i+1,j],dp[i+1,j+1]) + triangle[i,j]
//初始状态：dp[n-1, j] = triangle[n-1,j]，则dp可直接复用triangle，无需再额外初始化
//TC: O(n2), SC: O(n2) - 题目要求SC: O(n)，即使用一维数组
func method1(triangle [][]int) int {
	if len(triangle) == 0 {
		return 0
	}

	dp := triangle
	for i := len(triangle) - 2; i >= 0; i-- {
		for j := 0; j < len(triangle[i]); j++ {
			dp[i][j] = min(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j]
		}
	}

	return dp[0][0]
}

//也可不新申请二维数组，直接原地修改 - triangle被修改了，不可重复测试
//TC: O(n2), SC: O(n2) - 题目要求SC: O(n)，即使用一维数组
func method2(triangle [][]int) int {
	if len(triangle) == 0 {
		return 0
	}

	for i := len(triangle) - 2; i >= 0; i-- {
		for j := 0; j < len(triangle[i]); j++ {
			triangle[i][j] = min(triangle[i+1][j], triangle[i+1][j+1]) + triangle[i][j]
		}
	}

	return triangle[0][0]
}

//降维：自底向上递推时，只需要使用上一层（i较大那一层）的比较结果，不需要使用m层
//dp被修改，triangle相应行也会被修改
//SC: O(n)
func method3(triangle [][]int) int {
	if len(triangle) == 0 {
		return 0
	}

	dp := triangle[len(triangle)-1]
	for i := len(triangle) - 2; i >= 0; i-- {
		for j := 0; j < len(triangle[i]); j++ {
			dp[j] = min(dp[j], dp[j+1]) + triangle[i][j] //容易写错，是j不是i
		}
	}
	return dp[0]
}

//BruteForce: DFS - TimeOut
func method4(triangle [][]int) int {
	if len(triangle) == 0 {
		return 0
	}

	return dfs1(triangle, 0, 0)
}

func dfs1(triangle [][]int, i int, j int) int {
	//terminator
	if i == len(triangle)-1 {
		return triangle[i][j]
	}

	//process
	//No Process, can print `path`

	//drill down
	left := dfs1(triangle, i+1, j)
	right := dfs1(triangle, i+1, j+1)

	//clear status
	//Note: no need to clear status of `path`
	//if like  visited[][], need recover

	return min(left, right) + triangle[i][j]
}

//DFS+Memorize - AC
//构建一个triangle大小的二维数组，用来记忆最小值，再递归到此值时直接返回
//测试用例中：比如递归到3时需要看6和5，递归到4时需要看5和7，则5就可以直接返回
func method5(triangle [][]int) int {
	if len(triangle) == 0 {
		return 0
	}

	memo := make([][]int, len(triangle)) //len(triangle)行
	for i := range memo {
		memo[i] = make([]int, len(triangle[i])) //每行跟triangle行相同列
	}
	return dfs2(triangle, 0, 0, memo)
}

func dfs2(triangle [][]int, i int, j int, memo [][]int) int {
	//terminator
	if i == len(triangle)-1 {
		memo[i][j] = triangle[i][j]
		return memo[i][j]
	}

	//if not calculated
	if memo[i][j] == 0 {
		left := dfs2(triangle, i+1, j, memo)
		right := dfs2(triangle, i+1, j+1, memo)
		memo[i][j] = min(left, right) + triangle[i][j]
	}

	return memo[i][j]
}
