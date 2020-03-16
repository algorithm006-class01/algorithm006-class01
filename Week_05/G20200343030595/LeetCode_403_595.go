package main

import "math"

func canCross(stones []int) bool {
	if len(stones) == 0 {
		return false
	}

	if len(stones) == 1 {
		return stones[0] == 0
	}
	last := stones[len(stones)-1]
	n := int(math.Sqrt(float64(2*last)+0.25)-0.5) + 5
	dp := make([][]bool, len(stones))
	for i := 0; i < len(stones); i++ {
		dp[i] = make([]bool, n)
	}

	m := make(map[int]int)
	for i, stone := range stones {
		m[stone] = i
	}

	dp[0][0] = true
	for i := 0; i < len(stones); i++ {
		p := stones[i]
		for j := 1; j+1 < n; j++ {
			if (p-j == 0 && p == 1) ||
				(m[p-j] > 0 && (dp[m[p-j]][j+1] || dp[m[p-j]][j] || dp[m[p-j]][j-1])) {
				dp[i][j] = true
			}
		}
	}

	for i := 0; i < n; i++ {
		if dp[len(stones)-1][i] {
			return true
		}
	}
	return false
}
