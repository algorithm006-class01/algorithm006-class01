package main

import "fmt"

func maximalSquare(matrix [][]byte) int {
	if len(matrix) < 1{
		return 0
	}
	m, n := len(matrix), len(matrix[0])
	dp := make([][]int, m+1)
	for i:=0; i<=m; i++ {
		dp[i] = make([]int, n+1)
	}

	maxLen := 0
	for i:=1; i<m+1; i++ {
		for j:=1; j<n+1; j++ {
			if matrix[i-1][j-1] == '1'{
				dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
				fmt.Printf("dp[%v][%v]=%v\n", i, j, dp[i][j])
				maxLen = max(maxLen, dp[i][j])
			}
		}
	}
	return maxLen * maxLen
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b, c int) int {
	tmp := a
	if tmp > b {
		tmp = b
	}
	if tmp > c {
		tmp = c
	}
	return tmp
}
