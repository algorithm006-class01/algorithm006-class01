package main

func checkRecord(n int) int {
	mod := int(1e9) + 7
	dp := [][]int{
		[]int{1, 2, 4},
		[]int{0, 1, 4},
	}

	for i := 3; i <= n; i++ {
		dp[0] = append(dp[0], 0)
		dp[0][i] += dp[0][i-1]
		dp[0][i] += dp[0][i-2]
		dp[0][i] += dp[0][i-3]
		dp[0][i] %= mod

		dp[1] = append(dp[1], 0)
		dp[1][i] += dp[0][i-1]
		dp[1][i] += dp[0][i-2]
		dp[1][i] += dp[0][i-3]

		dp[1][i] += dp[1][i-1]
		dp[1][i] += dp[1][i-2]
		dp[1][i] += dp[1][i-3]
		dp[1][i] %= mod
	}
	return (dp[0][n] + dp[1][n]) % mod
}
