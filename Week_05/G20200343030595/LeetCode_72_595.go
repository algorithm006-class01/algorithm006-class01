package main

func minDistance(word1 string, word2 string) int {
	m, n := len(word1), len(word2)
	if n*m == 0 {
		return n + m
	}
	dp := make([][]int, m+1)
	for i:=0; i<=m; i++ {
		dp[i] = make([]int, n+1)
		dp[i][0] = i
	}
	for i:=0; i<=n; i++ {
		dp[0][i] = i
	}

	for i:=1; i<=m; i++ {
		for j:=1; j<=n; j++{
			left := dp[i-1][j] + 1
			down := dp[i][j-1] + 1
			left_down := dp[i-1][j-1]
			if word1[i-1] != word2[j-1] {
				left_down++
			}
			dp[i][j] = min(left, min(down, left_down))
		}
	}
	return dp[m][n]
}

func min(a, b int )int {
	if a<b {
		return a
	}
	return b
}
